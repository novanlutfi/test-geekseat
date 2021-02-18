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
	
	private static List<Villager> villagerList = new ArrayList<>();
	
	static {
		villagerList.add(new Villager(1, 3));
		villagerList.add(new Villager(2, 4));
		villagerList.add(new Villager(3, 5));
	}
	
	
	@Test
	public void testCountAverageNumber() throws Exception {
		VillagerService service = new VillagerService();
		Double result = service.countAverageNumber(villagerList);
		Assertions.assertEquals(result, Double.valueOf(2));
	}
	
}
