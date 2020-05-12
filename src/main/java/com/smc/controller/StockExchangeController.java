package com.smc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smc.model.StockExchange;
import com.smc.service.StockExchangeService;


@RestController
@RequestMapping("/exchange")
public class StockExchangeController {
	@Autowired
	private StockExchangeService stockExchangeService;
	
	@GetMapping
	public List<StockExchange> findAllExchanges(){
		return this.stockExchangeService.findAllStockExchanges();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StockExchange> findById(@PathVariable String id){
		StockExchange stockExchange = this.stockExchangeService.findStockExchangeById(id);
		return ResponseEntity.ok(stockExchange);
	}
	
	@PostMapping
	public ResponseEntity<StockExchange> add(@RequestBody StockExchange stockExchange){
		StockExchange stockExchangeEntity = this.stockExchangeService.addStockExchange(stockExchange);
		return ResponseEntity.status(HttpStatus.CREATED).body(stockExchangeEntity); 
	}
	
	@PutMapping
	public ResponseEntity<StockExchange> update(StockExchange stockExchange){
		StockExchange stockExchangeEntity = this.stockExchangeService.updateStockExchange(stockExchange);
		return ResponseEntity.ok(stockExchangeEntity); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable String id){
		this.stockExchangeService.delete(id);
		return ResponseEntity.ok("Delete stock exchange successfully.");
	}
}
