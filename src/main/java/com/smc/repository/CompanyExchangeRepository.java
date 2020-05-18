package com.smc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.smc.model.CompanyExchange;
import com.smc.model.StockExchange;

/**
 * 
 * @Description: Company exchange DAO interface for CRUD refers Create, Read, Update,
 *               Delete, this will be auto implemented by spring into a bean
 *               called companyExchangeRepository
 * @author Chen Wei
 * @date May 18, 2020
 *
 */
public interface CompanyExchangeRepository extends CrudRepository<CompanyExchange, String> {
	
	/**
	 * 
	 * @Title: findByCompIdAndStockExchange method
	 * @Description: define the find company by stock code and stock exchange method that will auto implemented by spring.
	 * @return List<CompanyExchange> list of company exchange entity
	 */
	List<CompanyExchange> findByCompIdAndStockExchange(String stockCode, StockExchange stockExchange);
	
}