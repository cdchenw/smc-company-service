package com.smc.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.smc.model.Company;

/**
 * 
 * @Description: Company DAO interface for CRUD refers Create, Read, Update,
 *               Delete, this will be auto implemented by spring into a bean
 *               called companyRepository
 * @author Chen Wei
 * @date May 18, 2020
 *
 */
public interface CompanyRepository extends CrudRepository<Company, String> {

	/**
	 * 
	 * @Title: findAll method
	 * @Description: define the find all companies method that will auto implemented by spring.
	 * @return List<Company> list of company entity
	 */
	List<Company> findAll();

}