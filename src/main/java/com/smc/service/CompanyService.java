package com.smc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smc.model.Company;
import com.smc.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyService {

	private final CompanyRepository companyRepository;

	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	public List<Company> findAllCompanies() {
		List<Company> iterCompany = this.companyRepository.findAll();//.fetchCompanyBySQL();
//		iterCompany.forEach((Company company)->{
//			company.setCompanyExchanges(company.getCompanyExchanges());
//		});
		return iterCompany;
	}
	
	public Company findCompanyById(String companyId) {
		Optional<Company> company = this.companyRepository.findById(companyId);
		if(company.isPresent()) {
			company.get().getCompanyExchanges();
		}
		
		return company.isPresent() ? company.get() : null;
	}

	public Company addCompany(Company company) {
		return this.companyRepository.save(company);
	}

	public Company updateCompany(Company company) {
		return this.companyRepository.save(company);
	}

	public void delete(String companyId) {
		this.companyRepository.deleteById(companyId);
	}

}
