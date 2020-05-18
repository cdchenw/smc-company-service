package com.smc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smc.model.CompanyExchange;
import com.smc.model.IpoPlanned;
import com.smc.model.StockExchange;
import com.smc.repository.CompanyExchangeRepository;
import com.smc.repository.IpoPlannedRepository;
import com.smc.vo.IpoPlanVO;

import java.util.List;
import java.util.Optional;

/**
 * 
 * @Description: IPO plans service layer of business logic
 * @author Chen Wei
 * @date May 18, 2020
 *
 */
@Service
@Transactional
public class IpoPlannedService {
	private final Logger logger = LoggerFactory.getLogger(IpoPlannedService.class);

	@Autowired
	private CompanyExchangeRepository companyExchangeRepository;
	@Autowired
	private IpoPlannedRepository ipoPlannedRepository;


	/**
	 * 
	 * @Title: Query method: findAll
	 * @Description: Find out all companies
	 * @return List<Company> list of company entity
	 */
	public List<IpoPlanned> findAll() {
		List<IpoPlanned> listIpoPlanned = this.ipoPlannedRepository.fetchSortedAllIpoPlans();
		return listIpoPlanned;
	}
	
	/**
	 * 
	 * @Title: Query Method: findCompanyById
	 * @Description: Find company by primary id key
	 * @param id company id
	 * @return Company company entity
	 */
	public IpoPlanned findById(String ipoId) {
		Optional<IpoPlanned> ipoPlanned = this.ipoPlannedRepository.findById(ipoId);
		return ipoPlanned.isPresent() ? ipoPlanned.get() : null;
	}

	/**
	 * 
	 * @Title: Create Method: addCompany
	 * @Description: Create a new company
	 * @param company company instance
	 * @return Company company entity
	 */
	public IpoPlanned addIpoPlanned(IpoPlanVO ipoPlanVO) throws Exception {
		StockExchange stockExchange = new StockExchange();
		stockExchange.setId(ipoPlanVO.getExchangeId());
		List<CompanyExchange> listCompanyExchange = this.companyExchangeRepository.findByCompIdAndStockExchange(ipoPlanVO.getCompId(), stockExchange);
		
		if(listCompanyExchange!=null && listCompanyExchange.size()>0) {
			String compExchangeId = listCompanyExchange.get(0).getId();
			
			logger.info("found compExchangeId in db", compExchangeId);
			
			IpoPlanned ipoPlanned = new IpoPlanned();
			ipoPlanned.setId(compExchangeId);
			ipoPlanned.setPricePerShare(ipoPlanVO.getPricePerShare());
			ipoPlanned.setTotalShare(ipoPlanVO.getTotalShare());
			ipoPlanned.setOpenDate(ipoPlanVO.getOpenDate());
			ipoPlanned.setRemars(ipoPlanVO.getRemarks());
			
			
			return this.ipoPlannedRepository.save(ipoPlanned);
		}else {
			throw new Exception("Cann't fetch valid data, because of incorrect stock code and exchange id mapping");
		}
	}
	
	/**
	 * 
	 * @Title: Update Method: updateCompany
	 * @Description: Updating an existed company
	 * @param company company instance
	 * @return Company company entity
	 */
	@Transactional
	public IpoPlanned updateIpoPlanned(IpoPlanVO ipoPlanVO) throws Exception {
		this.ipoPlannedRepository.deleteById(ipoPlanVO.getId());
		return this.addIpoPlanned(ipoPlanVO);
	}

	/**
	 * 
	 * @Title: Delete Method: delete
	 * @Description: Delete company by primary id key
	 * @param companyId company id
	 * @return Company company entity
	 */
	public void delete(String ipoId) {
		this.ipoPlannedRepository.deleteById(ipoId);
	}

}
