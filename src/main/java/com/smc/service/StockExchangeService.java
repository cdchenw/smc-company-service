package com.smc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smc.model.StockExchange;
import com.smc.repository.StockExchangeRepository;

import java.util.List;
import java.util.Optional;

/**
 * 
 * @Description: Stock Exchange service layer of business logic
 * @author Chen Wei
 * @date May 18, 2020
 *
 */
@Service
@Transactional
public class StockExchangeService {

	private final StockExchangeRepository stockExchangeRepository;

	/**
	 * 
	 * constructor of creating a new StockExchangeService instance.
	 * @param stockExchangeService Inject with StockExchangeService instance
	 */
	public StockExchangeService(StockExchangeRepository stockExchangeRepository) {
		this.stockExchangeRepository = stockExchangeRepository;
	}

	/**
	 * 
	 * @Title: Query method: findAllStockExchanges
	 * @Description: Find out all stock exchanges
	 * @return List<StockExchange> list of stock exchange entity
	 */
	public List<StockExchange> findAllStockExchanges() {
		List<StockExchange> iterStockExchange = this.stockExchangeRepository.findAll();
		return iterStockExchange;
	}
	
	/**
	 * 
	 * @Title: Query Method: findStockExchangeById
	 * @Description: Find stock exchange by primary id key
	 * @param exchangeId stock exchange id
	 * @return StockExchange stock exchange entity
	 */
	public StockExchange findStockExchangeById(String exchangeId) {
		Optional<StockExchange> exchange = this.stockExchangeRepository.findById(exchangeId);
		return exchange.isPresent() ? exchange.get() : null;
	}

	/**
	 * 
	 * @Title: Create Method: addStockExchange
	 * @Description: Create a new stock exchange
	 * @param exchange stock exchange instance
	 * @return StockExchange stock exchange entity
	 */
	public StockExchange addStockExchange(StockExchange exchange) {
		return this.stockExchangeRepository.save(exchange);
	}

	/**
	 * 
	 * @Title: Update Method: updateStockExchange
	 * @Description: Updating an existed stock exchange
	 * @param exchange stock exchange instance
	 * @return StockExchange stock exchange entity
	 */
	public StockExchange updateStockExchange(StockExchange exchange) {
		return this.stockExchangeRepository.save(exchange);
	}

	/**
	 * 
	 * @Title: Delete Method: delete
	 * @Description: Delete stock exchange by primary id key
	 * @param exchangeId stock exchange id
	 * @return void
	 */
	public void delete(String exchangeId) {
		this.stockExchangeRepository.deleteById(exchangeId);
	}

}
