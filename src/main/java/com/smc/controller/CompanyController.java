package com.smc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smc.model.Company;
import com.smc.service.CompanyService;

/**
 * 
 * @Description: Rest API controller class for company.
 * @author Chen Wei
 * @date May 18, 2020
 *
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
	private static Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	@Autowired
	private CompanyService companyService;

	/**
	 * 
	 * @Title: Rest API of finding out all companies
	 * @Description: Query method: Find out all companies
	 * @return List<Company> JSON format response with company entity List
	 */
	//@RequestAttribute("currentuser") Object currentuser
	@GetMapping
	public List<Company> findAllCompanies() {
//		logger.info("current user>>>", currentuser);
		return this.companyService.findAllCompanies();
	}

	/**
	 * 
	 * @Title: : Rest API of finding out company by company id parameter
	 * @Description: Query method: Find company by primary id key
	 * @param id company id
	 * @return ResponseEntity<Company> JSON format response with company entity
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Company> findById(@PathVariable String id) {
		Company company = this.companyService.findCompanyById(id);
		return ResponseEntity.ok(company);
	}

	/**
	 * 
	 * @Title: Rest API of creating new company
	 * @Description: Create method: Create a new company
	 * @param company JSON formated request body of company entity
	 * @return ResponseEntity<Company> JSON format response with company entity
	 */
	@PostMapping
	public ResponseEntity<Company> add(@RequestBody @Validated Company company) {
		Company companyEntity = this.companyService.addCompany(company);
		return ResponseEntity.status(HttpStatus.CREATED).body(companyEntity);
	}

	/**
	 * 
	 * @Title: Rest API of updating an existed company
	 * @Description: Update method: Updating an existed company
	 * @param company JSON formated request body of company entity
	 * @param id company id
	 * @return ResponseEntity<Company> JSON format response with company entity
	 */
	@PutMapping
	public ResponseEntity<Company> update(@RequestBody @Validated Company company) {
		Company companyEntity = this.companyService.updateCompany(company);
		return ResponseEntity.ok(companyEntity);
	}

	/**
	 * 
	 * @Title: Rest API of deleting an existed company by id parameter
	 * @Description: Delete method: Delete company by primary id key
	 * @param id Company id
	 * @return ResponseEntity<String> JSON format response with delete success message
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> delete(@PathVariable String id) {
		this.companyService.delete(id);
		Map<String, String> rsMap= new HashMap<String, String>();
		rsMap.put("message", "Successfully delete company with id=" + id);
		return ResponseEntity.ok(rsMap);
	}
}
