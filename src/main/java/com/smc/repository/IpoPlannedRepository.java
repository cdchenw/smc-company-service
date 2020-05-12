package com.smc.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.smc.model.IpoPlanned;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface IpoPlannedRepository extends CrudRepository<IpoPlanned, String> {
	
	@Query(value="select i.* from tb_ipo_planned i order by open_date desc", nativeQuery = true)
	List<IpoPlanned> fetchSortedAllIpoPlans();  
	
//	@Modifying
//	@Transactional
//	@Query(value="update tb_ipo_planned i set i.order by open_date desc", nativeQuery = true)
//	List<IpoPlanned> updateIpoPlan(IpoPlanned ipoPlanned);  

}