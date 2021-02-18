package com.geekseat.test.testgeekseat.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.geekseat.test.testgeekseat.model.Villager;
import com.geekseat.test.testgeekseat.service.VillagerService;

import io.swagger.annotations.ApiOperation;

@RestController
public class KickOutTheWitchController {
	@Autowired
	VillagerService villagerService;
	
	@GetMapping("/")
	public String index() {
		return "Hello";
	}
	
	@ApiOperation(value = "Service to count average number of people the witch killed on year of birth of those people")
	@PostMapping(path = "/count-average-number")
	public ResponseEntity<String> countAverageNumber(@Valid @RequestBody List<Villager> villagerList) {
		Double result = villagerService.countAverageNumber(villagerList);
		
		if(result <= 0) {
			return new ResponseEntity<String>("-1",HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>("average number of people the witch killed on year of birth of those people = " + result.toString(),
				HttpStatus.OK);
	}
}
