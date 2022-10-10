package com.bigcorp.booking.service;

import javax.inject.Inject;

import org.apache.openejb.testing.SingleApplicationComposerRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SingleApplicationComposerRunner.class)
public class RestaurantServiceTest {

	@Inject
	protected RestaurantTypeService restaurantTypeService;

	@Test
	public void testFind() {
		restaurantTypeService.findById(3l);
	}

}
