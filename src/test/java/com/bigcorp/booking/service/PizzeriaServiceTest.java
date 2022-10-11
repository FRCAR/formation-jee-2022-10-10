package com.bigcorp.booking.service;

import javax.inject.Inject;

import org.apache.openejb.testing.SingleApplicationComposerRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bigcorp.booking.model.Pizzeria;
import com.bigcorp.booking.model.Restaurant;
import com.bigcorp.booking.model.RestaurantType;

@RunWith(SingleApplicationComposerRunner.class)
public class PizzeriaServiceTest {

	@Inject
	protected PizzeriaService pizzeriaService;

	@Test
	public void testSave() {
		Pizzeria pizzeria = new Pizzeria();
		pizzeria.setName("Chez Luigi");
		pizzeria.setPizzaName("Margherita");
		pizzeriaService.save(pizzeria);
	}

}
