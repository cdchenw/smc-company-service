package com.smc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


@RestController
@RequestMapping("/company/ipo")
public class IpoPlannedController {
	@Autowired
	private IpoPlannedService ipoPlannedService;
	
	@GetMapping
	public List<IpoPlanned> findAll(){
		return this.ipoPlannedService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<IpoPlanned> findById(@PathVariable String id){
		IpoPlanned ipoEntity = this.ipoPlannedService.findById(id);
		return ResponseEntity.ok(ipoEntity);
	}
	
	@PostMapping
	public ResponseEntity<IpoPlanned> add(@RequestBody IpoPlanVO ipoPlanVO) throws Exception{
		IpoPlanned ipoEntity = this.ipoPlannedService.addIpoPlanned(ipoPlanVO);
		return ResponseEntity.status(HttpStatus.CREATED).body(ipoEntity); 
	}
	
	@PutMapping
	public ResponseEntity<IpoPlanned> update(@RequestBody IpoPlanVO ipoPlanVO) throws Exception{
		IpoPlanned ipoEntity = this.ipoPlannedService.updateIpoPlanned(ipoPlanVO);
		return ResponseEntity.ok(ipoEntity); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable String id){
		this.ipoPlannedService.delete(id);
		return ResponseEntity.ok("Delete company successfully.");
	}
}
