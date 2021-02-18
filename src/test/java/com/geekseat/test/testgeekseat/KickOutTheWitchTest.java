package com.geekseat.test.testgeekseat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import com.geekseat.test.testgeekseat.model.Villager;
import com.geekseat.test.testgeekseat.service.VillagerService;

public class KickOutTheWitchTest {

	private MockMvc mockMvc;
	
	private static List<Villager> villagerListCorrect = new ArrayList<>();
	private static List<Villager> villagerListIncorrect = new ArrayList<>();
	
	static {
		villagerListCorrect.add(new Villager(1, 3));
		villagerListCorrect.add(new Villager(2, 4));
		villagerListCorrect.add(new Villager(3, 5));
		
		villagerListIncorrect.add(new Villager(6, 5));
		villagerListIncorrect.add(new Villager(2, 6));
		villagerListIncorrect.add(new Villager(3, 5));
	}
	
	
	@Test
	public void testCorrectDataCountAverageNumber() throws Exception {
		VillagerService service = new VillagerService();
		Double result = service.countAverageNumber(villagerListCorrect);
		Assertions.assertEquals(result, Double.valueOf(2));
	}
	
	@Test
	public void testIncorrectDataCountAverageNumber() throws Exception {
		VillagerService service = new VillagerService();
		Double result = service.countAverageNumber(villagerListIncorrect);
		Assertions.assertEquals(result, Double.valueOf(-1));
	}
}
