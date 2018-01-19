package com.bank.fund;

import org.springframework.data.repository.CrudRepository;

import com.bank.fund.Fund;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface FundRepository extends CrudRepository<Fund, Long> {

}
