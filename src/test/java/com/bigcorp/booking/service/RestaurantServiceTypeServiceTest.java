package com.bigcorp.booking.service;

import javax.inject.Inject;

import org.apache.openejb.testing.SingleApplicationComposerRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bigcorp.booking.model.RestaurantType;

@RunWith(SingleApplicationComposerRunner.class)
public class RestaurantServiceTypeServiceTest {

	@Inject
	protected RestaurantTypeService restaurantTypeService;

	@Test
	public void testFind() {
		Assert.assertNull(restaurantTypeService.findById(3l));
	}

	@Test
	public void testSave() {
		RestaurantType restaurantType = new RestaurantType();
		restaurantType.setName("Mon beau restaurant");
		RestaurantType restaurantTypeSaved = this.restaurantTypeService.save(restaurantType);
		Assert.assertNotNull(restaurantTypeService.findById(restaurantTypeSaved.getId()));
	}

}
