package com.smc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smc.model.Company;
import com.smc.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

/**
 * 
 * @Description: Company service layer of business logic
 * @author Chen Wei
 * @date May 18, 2020
 *
 */
@Service
@Transactional
public class CompanyService {

	private final CompanyRepository companyRepository;

	/**
	 * 
	 * constructor of creating a new CompanyService instance.
	 * @param companyRepository Inject with CompanyRepository instance
	 */
	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	/**
	 * 
	 * @Title: Query method: findAllCompanies
	 * @Description: Find out all companies
	 * @return List<Company> list of company entity
	 */
	public List<Company> findAllCompanies() {
		List<Company> iterCompany = this.companyRepository.findAll();
		return iterCompany;
	}

	/**
	 * 
	 * @Title: Query Method: findCompanyById
	 * @Description: Find company by primary id key
	 * @param id company id
	 * @return Company company entity
	 */
	public Company findCompanyById(String companyId) {
		Optional<Company> company = this.companyRepository.findById(companyId);
		if (company.isPresent()) {
			company.get().getCompanyExchanges();
		}

		return company.isPresent() ? company.get() : null;
	}

	/**
	 * 
	 * @Title: Create Method: addCompany
	 * @Description: Create a new company
	 * @param company company instance
	 * @return Company company entity
	 */
	public Company addCompany(Company company) {
		return this.companyRepository.save(company);
	}

	/**
	 * 
	 * @Title: Update Method: updateCompany
	 * @Description: Updating an existed company
	 * @param company company instance
	 * @return Company company entity
	 */
	public Company updateCompany(Company company) {
		return this.companyRepository.save(company);
	}

	/**
	 * 
	 * @Title: Delete Method: delete
	 * @Description: Delete company by primary id key
	 * @param companyId company id
	 * @return Company company entity
	 */
	public void delete(String companyId) {
		this.companyRepository.deleteById(companyId);
	}

}
