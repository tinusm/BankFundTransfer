package com.bank.fund;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bank.fund.Fund;
import com.bank.fund.FundRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/fundtransfer") // This means URL's start with
										// /accountsummary (after Application
										// path)
public class FundTransferController {
	@Autowired // This means to get the bean called userRepository
				// Which is auto-generated by Spring, we will use it to handle
				// the data
	private FundRepository accountRepository;

	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private TransactionRepository transactionRepository;

	@GetMapping(path = "/all/{id}/{amount}")
	public @ResponseBody Long fundTransfer(@PathVariable Long id, @PathVariable("amount") Long amount) {
		Long acc = null;
		Long bal = null;
		Long balanceafterdebit = null;
		Long previousBalance = null;
		Long dummyCurrentBalance = (long) 0;
		Long dummyDebit = (long) 0;
		Long dummyCredit = (long) 0;

		Fund account = accountRepository.findOne(id);
		if (account.getAccountid() != null) {
			acc = account.getAccountid();
		}
		if (account.getBalance() != null) {
			bal = account.getBalance();
		}

		previousBalance = bal;

		System.out.println("Previous Balance Amount : " + previousBalance);

		System.out.println("Debiting Amount : " + amount);

		if (bal > 0 || bal > amount) {
			balanceafterdebit = bal - amount;

		}

		System.out.println("Balance Amount after debeting : " + balanceafterdebit);

		if (balanceafterdebit != null) {

			account.setBalance(balanceafterdebit);

			accountRepository.save(account);

		}
		Transaction trans = new Transaction();
		trans.setAccountid(account.getAccountid());
		trans.setAccountnumber(account.getAccountnumber());
		trans.setPreviousbalance(account.getBalance());
		trans.setCurrentbalance(dummyCurrentBalance);
		trans.setCustomername(account.getCustomername());
		trans.setBranch(account.getBranch());
		trans.setDebit(dummyDebit);
		trans.setCredit(dummyCredit);
		transactionRepository.save(trans);

		if (balanceafterdebit != null && trans != null) {

			trans.setCurrentbalance(balanceafterdebit);
			trans.setPreviousbalance(previousBalance);
			trans.setDebit(amount);

			transactionRepository.save(trans);

			System.out.println("Sucessfully updated in Transaction Table");

		}

		return account.getBalance();
	}

}
