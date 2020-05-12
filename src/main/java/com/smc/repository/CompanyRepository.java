package com.smc.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.smc.model.Company;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CompanyRepository extends CrudRepository<Company, String> {
	
	List<Company> findAll();   
	
	Optional<Company> findCompaniesByName(String companyName);
	
	@Transactional
	@Query(value = "select c.* from tb_company c",nativeQuery = true)
	public List<Company> fetchCompanyBySQL();

}