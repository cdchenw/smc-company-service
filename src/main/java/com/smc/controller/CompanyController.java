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

import com.smc.model.Company;
import com.smc.service.CompanyService;


@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	@GetMapping
	public List<Company> findAllCompanies(){
		return this.companyService.findAllCompanies();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> findById(@PathVariable String id){
		Company company = this.companyService.findCompanyById(id);
		return ResponseEntity.ok(company);
	}
	
	@PostMapping
	public ResponseEntity<Company> add(@RequestBody Company company){
		Company companyEntity = this.companyService.addCompany(company);
		return ResponseEntity.status(HttpStatus.CREATED).body(companyEntity); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Company> update(@RequestBody Company company, @PathVariable String id){
		company.setId(id);
		Company companyEntity = this.companyService.updateCompany(company);
		return ResponseEntity.ok(companyEntity); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable String id){
		this.companyService.delete(id);
		return ResponseEntity.ok("Delete company successfully.");
	}
}
