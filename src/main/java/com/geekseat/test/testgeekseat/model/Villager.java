package com.geekseat.test.testgeekseat.model;

import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Data Villager")
public class Villager {
	@Min(value = 0, message = "Age of Death minimal bernilai 0")
	private Integer age_of_death;
	@Min(value = 0, message = "Year of Death minimal bernilai 0")
	private Integer year_of_death;
	public Integer getAge_of_death() {
		return age_of_death;
	}
	public void setAge_of_death(Integer age_of_death) {
		this.age_of_death = age_of_death;
	}
	public Integer getYear_of_death() {
		return year_of_death;
	}
	public void setYear_of_death(Integer year_of_death) {
		this.year_of_death = year_of_death;
	}
	
}
