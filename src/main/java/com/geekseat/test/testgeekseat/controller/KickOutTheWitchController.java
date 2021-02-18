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

@RestController
public class KickOutTheWitchController {
	@Autowired
	VillagerService vilagerService;
	
	@PostMapping(path = "/count-average-number")
	public ResponseEntity<String> countAverageNumber(@Valid @RequestBody List<Villager> villagerList) {
		int countData = villagerList.size();
		int sumPeopleKilled = 0;
		for(Villager villager : villagerList) {
			int difference = villager.getYear_of_death()-villager.getAge_of_death();
			if(difference < 0) return new ResponseEntity<String>("-1", HttpStatus.BAD_REQUEST);
			int peopleKilled = vilagerService.countVillagerKilled(difference);
			
			sumPeopleKilled += peopleKilled;
		}
		Double average = Double.valueOf(sumPeopleKilled) / Double.valueOf(countData);
		return new ResponseEntity<String>("average number of people the witch killed on year of birth of those people = " + average.toString(),
				HttpStatus.OK);
	}
}
