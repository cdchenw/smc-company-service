package com.smc.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.smc.model.Sector;

/**
 * 
 * @Description: Sector DAO interface for CRUD refers Create, Read, Update,
 *               Delete, this will be auto implemented by spring into a bean
 *               called sectorRepository
 * @author Chen Wei
 * @date Jun 7, 2020
 *
 */
public interface SectorRepository extends CrudRepository<Sector, String> {

	/**
	 * 
	 * @Title: findAll method
	 * @Description: define the find all sectors method that will auto implemented by spring.
	 * @return List<Sector> list of sector entity
	 */
	List<Sector> findAll();

}