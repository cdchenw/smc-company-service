package com.smc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.smc.model.CompanyExchange;
import com.smc.model.StockExchange;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CompanyExchangeRepository extends CrudRepository<CompanyExchange, String> {
	
	List<CompanyExchange> findByCompIdAndStockExchange(String stockCode, StockExchange stockExchange);
	
}