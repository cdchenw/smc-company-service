package com.smc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smc.model.Sector;
import com.smc.repository.SectorRepository;

import java.util.List;

/**
 * 
 * @Description: Sector service layer of business logic
 * @author Chen Wei
 * @date Jun 7, 2020
 *
 */
@Service
@Transactional
public class SectorService {

	private final SectorRepository sectorRepository;

	/**
	 * 
	 * constructor of creating a new SectorService instance.
	 * @param sectorService Inject with SectorService instance
	 */
	public SectorService(SectorRepository sectorRepository) {
		this.sectorRepository = sectorRepository;
	}

	/**
	 * 
	 * @Title: Query method: findAllSectors
	 * @Description: Find out all sectors
	 * @return List<Sector> list of sector entity
	 */
	public List<Sector> findAllSectors() {
		List<Sector> iterSector = this.sectorRepository.findAll();
		return iterSector;
	}

}
