package com.smc.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import com.smc.model.StockExchange;

/**
 * 
 * @Description: Unit Test for stock exchange controller rest API
 * @author Chen Wei
 * @date May 19, 2020
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
class StockExchangeControllerTest {
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private final String APIURL = "/exchange";
	
	/**
	 * 
	 * @Title: Test Method: testFindAllExchanges
	 * @Description: JUnit Test for rest API of finding out all stock exchanges
	 * @return void
	 * @throws Exception
	 */
	@Test
	void testFindAllExchanges() throws Exception {
		ParameterizedTypeReference<StockExchange[]> typeReference = new ParameterizedTypeReference<StockExchange[]>() {};
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> httpRequst = new HttpEntity<Object>(null, headers);
		ResponseEntity<StockExchange[]> response = restTemplate.exchange("/exchange", HttpMethod.GET, httpRequst, typeReference);
		StockExchange[] exchanges = response.getBody();

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(exchanges).isNotEmpty();
	}
	
	/**
	 * 
	 * @Title: Test Method: testStandardCRUD
	 * @Description: JUnit Test for rest API of CRUD
	 * @return void
	 * @throws Exception
	 */
	@Test
	void testStandardCRUD() throws Exception {
		//Step1: Create a new Stock Exchange
		ParameterizedTypeReference<StockExchange> typeReference = new ParameterizedTypeReference<StockExchange>() {};
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		StockExchange stockExchangeBody = new StockExchange();
		stockExchangeBody.setShortName("LSEN");
		stockExchangeBody.setName("London Stock Exchange");
		stockExchangeBody.setRegion("United Kingdom");
		stockExchangeBody.setBrief("London Stock Exchange is a stock exchange located in the City of London, England. As of April 2018, London Stock Exchange had a market capitalisation of US$4.59 trillion. It was founded in 1571, making it one of the oldest exchanges in the world. ");
		stockExchangeBody.setContactAddress("London");
		stockExchangeBody.setRemarks("ADMIN ADD");
		HttpEntity<Object> httpRequst = new HttpEntity<Object>(stockExchangeBody, headers);
		ResponseEntity<StockExchange> response = restTemplate.exchange(APIURL, HttpMethod.POST, httpRequst, typeReference);
		StockExchange stockExchange = response.getBody();

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(stockExchange).isNotNull();
		
		//Step2: Find stockExchange by primary key
		response = restTemplate.getForEntity(APIURL+"/"+stockExchange.getId(), StockExchange.class);
		stockExchange = response.getBody();

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(stockExchange).isNotNull();
		
		//Step3: Update Stock Exchange
		typeReference = new ParameterizedTypeReference<StockExchange>() {};
		stockExchange.setName("London Stock Exchange Ltd.");
		httpRequst = new HttpEntity<Object>(stockExchange, headers);
		response = restTemplate.exchange(APIURL, HttpMethod.PUT, httpRequst, typeReference);
		stockExchange = response.getBody();

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(stockExchange).isNotNull();
		
		//Step4: Delete stockExchange
		ParameterizedTypeReference<String> typeReference1 = new ParameterizedTypeReference<String>() {};
		httpRequst = new HttpEntity<Object>(null, headers);
		ResponseEntity<String> response1 = restTemplate.exchange(APIURL+"/"+stockExchange.getId(), HttpMethod.DELETE, httpRequst, typeReference1);

		assertThat(response1.getStatusCode()).isEqualTo(HttpStatus.OK);
		
	}
	
}
