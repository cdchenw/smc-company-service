package com.smc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.smc.model.StockExchange;

/**
 * 
 * @Description: Stock Exchange DAO interface for CRUD refers Create, Read, Update,
 *               Delete, this will be auto implemented by spring into a bean
 *               called stockExchangeRepository
 * @author Chen Wei
 * @date May 18, 2020
 *
 */
public interface StockExchangeRepository extends CrudRepository<StockExchange, String> {
	
	/**
	 * 
	 * @Title: findAll method
	 * @Description: override the find all companies method that will auto implemented by spring.
	 * @return List<StockExchange> list of stock exchange entity
	 */
	List<StockExchange> findAll();   
	
}