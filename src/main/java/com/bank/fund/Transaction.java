package com.bank.fund;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "fundtransactiontbl")

public class Transaction {

	@Id
	@Column(name="accountid")
    Long accountid;
	Long accountnumber;
	Long thirdpartyaccountnumber;
	Long previousbalance;
	Long currentbalance;
	String customername;
	String branch;
	Long debit;
	Long credit;
	public Long getAccountid() {
		return accountid;
	}
	public void setAccountid(Long accountid) {
		this.accountid = accountid;
	}
	public Long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(Long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public Long getPreviousbalance() {
		return previousbalance;
	}
	public void setPreviousbalance(Long previousbalance) {
		this.previousbalance = previousbalance;
	}
	public Long getThirdpartyaccountnumber() {
		return thirdpartyaccountnumber;
	}
	public void setThirdpartyaccountnumber(Long thirdpartyaccountnumber) {
		this.thirdpartyaccountnumber = thirdpartyaccountnumber;
	}
	public Long getCurrentbalance() {
		return currentbalance;
	}
	public void setCurrentbalance(Long currentbalance) {
		this.currentbalance = currentbalance;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Long getDebit() {
		return debit;
	}
	public void setDebit(Long debit) {
		this.debit = debit;
	}
	public Long getCredit() {
		return credit;
	}
	public void setCredit(Long credit) {
		this.credit = credit;
	}
	
	
}
