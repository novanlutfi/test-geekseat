package com.geekseat.test.testgeekseat.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.geekseat.test.testgeekseat.model.Villager;

@Component
public class VillagerService {
	public int countVillagerKilled(int year) {
		int a = 1;
		int b = 1;
		int c = 0;
		int sum = 0;
		for(int i=1; i<=year; i++) {
			 if(i==1) {
				 sum = a;
			 } else if(i==2) {
				 sum = a + b;
			 } else {
				 c = a + b;
				 a = b;
				 b = c;
				 sum = sum + c;
			 }
		}
		
		
		return sum;
	}
	
	public Double countAverageNumber(List<Villager> villagerList) {
		int countData = villagerList.size();
		int sumPeopleKilled = 0;
		for(Villager villager : villagerList) {
			int difference = villager.getYear_of_death()-villager.getAge_of_death();
			if(difference <= 0) return Double.valueOf(-1);
			int peopleKilled = countVillagerKilled(difference);
			
			sumPeopleKilled += peopleKilled;
		}
		return Double.valueOf(sumPeopleKilled) / Double.valueOf(countData);
	}
}
