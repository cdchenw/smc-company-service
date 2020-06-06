package com.smc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

/**
 * 
 * @Description: Rest API controller class for stock exchange.
 * @author Chen Wei
 * @date May 18, 2020
 *
 */

@RestController
@RequestMapping("/company/exchange")
public class StockExchangeController {
	@Autowired
	private StockExchangeService stockExchangeService;
	
	/**
	 * 
	 * @Title: Rest API of finding out all stock exchanges
	 * @Description: Query method: Find out all stock exchanges
	 * @return List<StockExchange> JSON format response with stock exchange entity List
	 */
	@GetMapping
	public List<StockExchange> findAllExchanges(){
		return this.stockExchangeService.findAllStockExchanges();
	}
	
	/**
	 * 
	 * @Title: : Rest API of finding out stock exchange by stock exchange id parameter
	 * @Description: Query method: Find stock exchange by primary id key
	 * @param id stock exchange id
	 * @return ResponseEntity<StockExchange> JSON format response with stock exchange entity
	 */
	@GetMapping("/{id}")
	public ResponseEntity<StockExchange> findById(@PathVariable String id){
		StockExchange stockExchange = this.stockExchangeService.findStockExchangeById(id);
		return ResponseEntity.ok(stockExchange);
	}
	
	/**
	 * 
	 * @Title: Rest API of creating new stock exchange
	 * @Description: Create method: Create a new stock exchange
	 * @param stock exchange JSON formated request body of stock exchange entity
	 * @return ResponseEntity<StockExchange> JSON format response with stock exchange entity
	 */
	@PostMapping
	public ResponseEntity<StockExchange> add(@RequestBody @Validated StockExchange stockExchange){
		StockExchange stockExchangeEntity = this.stockExchangeService.addStockExchange(stockExchange);
		return ResponseEntity.status(HttpStatus.CREATED).body(stockExchangeEntity); 
	}
	
	/**
	 * 
	 * @Title: Rest API of updating an existed stock exchange
	 * @Description: Update method: Updating an existed stock exchange
	 * @param stock exchange JSON formated request body of stock exchange entity
	 * @return ResponseEntity<StockExchange> JSON format response with stock exchange entity
	 */
	@PutMapping
	public ResponseEntity<StockExchange> update(@RequestBody @Validated StockExchange stockExchange){
		StockExchange stockExchangeEntity = this.stockExchangeService.updateStockExchange(stockExchange);
		return ResponseEntity.ok(stockExchangeEntity); 
	}
	
	/**
	 * 
	 * @Title: Rest API of deleting an existed stock exchange by id parameter
	 * @Description: Delete method: Delete stock exchange by primary id key
	 * @param id stock exchange id
	 * @return ResponseEntity<String> JSON format response with delete success message
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable String id){
		this.stockExchangeService.delete(id);
		return ResponseEntity.ok("Delete stock exchange successfully.");
	}
}
