package com.smc.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.smc.model.IpoPlanned;

/**
 * 
 * @Description: IPO plan DAO interface for CRUD refers Create, Read, Update,
 *               Delete, this will be auto implemented by spring into a bean
 *               called ipoPlannedRepository
 * @author Chen Wei
 * @date May 18, 2020
 *
 */
public interface IpoPlannedRepository extends CrudRepository<IpoPlanned, String> {
	
	
	/**
	 * 
	 * @Title: fetchSortedAllIpoPlans method
	 * @Description: define the fetch all sorted IPO plans method that will auto implemented by spring.
	 * @return List<IpoPlanned> list of IPO plan entity
	 */
	@Query(value="select i.* from tb_ipo_planned i order by open_date desc", nativeQuery = true)
	List<IpoPlanned> fetchSortedAllIpoPlans();  
	
}