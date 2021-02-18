package com.geekseat.test.testgeekseat.service;

import org.springframework.stereotype.Component;

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
}
