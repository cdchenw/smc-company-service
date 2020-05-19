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

import com.smc.model.IpoPlanned;

/**
 * 
 * @Description: Unit Test for IPO plan controller rest API
 * @author Chen Wei
 * @date May 19, 2020
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
class IpoPlannedControllerTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private final String APIURL = "/company/ipo";
	
	/**
	 * 
	 * @Title: Test Method: testFindAllIPOPlans
	 * @Description: JUnit Test for rest API of finding out all IPO plans
	 * @return void
	 * @throws Exception
	 */
	@Test
	void testFindAllIPOPlans() throws Exception {
		ParameterizedTypeReference<IpoPlanned[]> typeReference = new ParameterizedTypeReference<IpoPlanned[]>() {};
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> httpRequst = new HttpEntity<Object>(null, headers);
		ResponseEntity<IpoPlanned[]> response = restTemplate.exchange(APIURL, HttpMethod.GET, httpRequst, typeReference);
		IpoPlanned[] ipoPlans = response.getBody();

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(ipoPlans).isNotEmpty();
	}
}
