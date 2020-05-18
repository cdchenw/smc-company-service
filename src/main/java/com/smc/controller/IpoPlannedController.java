package com.smc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smc.model.IpoPlanned;
import com.smc.service.IpoPlannedService;
import com.smc.vo.IpoPlanVO;

/**
 * 
 * @Description: Rest API controller class for IPO plan.
 * @author Chen Wei
 * @date May 18, 2020
 *
 */
@RestController
@RequestMapping("/company/ipo")
public class IpoPlannedController {
	@Autowired
	private IpoPlannedService ipoPlannedService;
	
	/**
	 * 
	 * @Title: Rest API of finding out all IPO plans
	 * @Description: Query method: Find out all IPO plans
	 * @return List<IpoPlanned> JSON format response with IPO plan entity List
	 */
	@GetMapping
	public List<IpoPlanned> findAll(){
		return this.ipoPlannedService.findAll();
	}
	
	/**
	 * 
	 * @Title: : Rest API of finding out IPO plan by id parameter
	 * @Description: Query method: Find IPO plan by primary id key
	 * @param id IPO plan id
	 * @return ResponseEntity<IpoPlanned> JSON format response with IPO plan entity
	 */
	@GetMapping("/{id}")
	public ResponseEntity<IpoPlanned> findById(@PathVariable String id){
		IpoPlanned ipoEntity = this.ipoPlannedService.findById(id);
		return ResponseEntity.ok(ipoEntity);
	}
	
	/**
	 * 
	 * @Title: Rest API of creating new IPO plan
	 * @Description: Create method: Create a new IPO plan
	 * @param IPO plan JSON formated request body of IPO plan entity
	 * @return ResponseEntity<IpoPlanned> JSON format response with IPO plan entity
	 */
	@PostMapping
	public ResponseEntity<IpoPlanned> add(@RequestBody @Validated IpoPlanVO ipoPlanVO) throws Exception{
		IpoPlanned ipoEntity = this.ipoPlannedService.addIpoPlanned(ipoPlanVO);
		return ResponseEntity.status(HttpStatus.CREATED).body(ipoEntity); 
	}
	
	/**
	 * 
	 * @Title: Rest API of updating an existed IPO plan
	 * @Description: Update method: Updating an existed IPO plan
	 * @param IPO plan JSON formated request body of IPO plan entity
	 * @return ResponseEntity<IpoPlanned> JSON format response with IPO plan entity
	 */
	@PutMapping
	public ResponseEntity<IpoPlanned> update(@RequestBody @Validated IpoPlanVO ipoPlanVO) throws Exception{
		IpoPlanned ipoEntity = this.ipoPlannedService.updateIpoPlanned(ipoPlanVO);
		return ResponseEntity.ok(ipoEntity); 
	}
	
	/**
	 * 
	 * @Title: Rest API of deleting an existed IPO plan by id parameter
	 * @Description: Delete method: Delete IPO plan by primary id key
	 * @param id IPO plan id
	 * @return ResponseEntity<String> JSON format response with delete success message
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable String id){
		this.ipoPlannedService.delete(id);
		return ResponseEntity.ok("Delete IPO plan successfully.");
	}
}
