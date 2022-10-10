package com.bigcorp.booking.service;

import javax.inject.Inject;

import org.apache.openejb.testing.SingleApplicationComposerRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SingleApplicationComposerRunner.class)
public class MyFirstTest {

	@Inject
	protected RestaurantService restaurantService;

	@Test
	public void testDeBase() {
		Assert.assertNotNull(restaurantService);
		Assert.assertNotNull(restaurantService.getRestaurantDao());
	}

}
