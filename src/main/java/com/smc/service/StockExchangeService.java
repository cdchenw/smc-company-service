package com.smc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smc.model.StockExchange;
import com.smc.repository.StockExchangeRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StockExchangeService {

	private final StockExchangeRepository stockExchangeRepository;

	public StockExchangeService(StockExchangeRepository stockExchangeRepository) {
		this.stockExchangeRepository = stockExchangeRepository;
	}

	public List<StockExchange> findAllStockExchanges() {
		List<StockExchange> iterStockExchange = this.stockExchangeRepository.findAll();
		return iterStockExchange;
	}
	
	public StockExchange findStockExchangeById(String exchangeId) {
		Optional<StockExchange> exchange = this.stockExchangeRepository.findById(exchangeId);
		return exchange.isPresent() ? exchange.get() : null;
	}

	public StockExchange addStockExchange(StockExchange exchange) {
		return this.stockExchangeRepository.save(exchange);
	}

	public StockExchange updateStockExchange(StockExchange exchange) {
		return this.stockExchangeRepository.save(exchange);
	}

	public void delete(String exchangeId) {
		this.stockExchangeRepository.deleteById(exchangeId);
	}

}
