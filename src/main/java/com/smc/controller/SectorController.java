package com.smc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smc.model.Sector;
import com.smc.service.SectorService;

/**
 * 
 * @Description: Rest API controller class for sector
 * @author Chen Wei
 * @date Jun 7, 2020
 *
 */

@RestController
@RequestMapping("/company/sector")
public class SectorController {
	@Autowired
	private SectorService sectorService;
	
	/**
	 * 
	 * @Title: Rest API of finding out all sectors
	 * @Description: Query method: Find out all sectors
	 * @return List<Sector> JSON format response with sector entity List
	 */
	@GetMapping
	public List<Sector> findAllSectors(){
		return this.sectorService.findAllSectors();
	}
	
}
