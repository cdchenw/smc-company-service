package com.smc.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

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

import com.smc.model.Company;

/**
 * 
 * @Description: Unit Test for company controller rest API
 * @author Chen Wei
 * @date May 18, 2020
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
class CompanyControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	/**
	 * 
	 * @Title: Test Method: testFindAllCompanies
	 * @Description: JUnit Test for rest API of finding out all companies
	 * @return void
	 * @throws Exception
	 */
	@Test
	void testFindAllCompanies() throws Exception {
		ParameterizedTypeReference<Company[]> typeReference = new ParameterizedTypeReference<Company[]>() {};
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> httpRequst = new HttpEntity<Object>(null, headers);
		ResponseEntity<Company[]> response = restTemplate.exchange("/company", HttpMethod.GET, httpRequst, typeReference);
		Company[] companies = response.getBody();

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(companies).isNotEmpty();
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
		//Step1: Create a new Company
		ParameterizedTypeReference<Company> typeReference = new ParameterizedTypeReference<Company>() {};
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Company companyBody = new Company();
		companyBody.setName("Oracle");
		companyBody.setTurnOver(new BigDecimal(5000000000.00));
		companyBody.setCeo("Athar Frank");
		companyBody.setBoardOfDirectors("Oracle directors");
		companyBody.setBriefWriteUp("company brief wirteup");
		HttpEntity<Object> httpRequst = new HttpEntity<Object>(companyBody, headers);
		ResponseEntity<Company> response = restTemplate.exchange("/company", HttpMethod.POST, httpRequst, typeReference);
		Company company = response.getBody();

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(company).isNotNull();
		
		//Step2: Find company by primary key
		response = restTemplate.getForEntity("/company/"+company.getId(), Company.class);
		company = response.getBody();

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(company).isNotNull();
		
		//Step3: Update company
		typeReference = new ParameterizedTypeReference<Company>() {};
		company.setCeo("Jony Simith");
		httpRequst = new HttpEntity<Object>(company, headers);
		response = restTemplate.exchange("/company/"+company.getId(), HttpMethod.PUT, httpRequst, typeReference);
		company = response.getBody();

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(company).isNotNull();
		
		//Step4: Delete company
		ParameterizedTypeReference<String> typeReference1 = new ParameterizedTypeReference<String>() {};
		httpRequst = new HttpEntity<Object>(null, headers);
		ResponseEntity<String> response1 = restTemplate.exchange("/company/"+company.getId(), HttpMethod.DELETE, httpRequst, typeReference1);

		assertThat(response1.getStatusCode()).isEqualTo(HttpStatus.OK);
		
	}
	
	/**
	 * 
	 * @Title: Test Method: test create method validation
	 * @Description: JUnit Test for rest API of create method request body validation
	 * @return void
	 * @throws Exception
	 */
	@Test
	void testCreateValidation() throws Exception {
		//Step1: Create a new Company
		ParameterizedTypeReference<Company> typeReference = new ParameterizedTypeReference<Company>() {};
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Company companyBody = new Company();
		companyBody.setName(null);
		companyBody.setTurnOver(new BigDecimal(5000000000.00));
		companyBody.setCeo("Athar Frank");
		companyBody.setBoardOfDirectors("Oracle directors");
		companyBody.setBriefWriteUp("company brief wirteup");
		HttpEntity<Object> httpRequst = new HttpEntity<Object>(companyBody, headers);
		ResponseEntity<Company> response = restTemplate.exchange("/company", HttpMethod.POST, httpRequst, typeReference);
	
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}

}
