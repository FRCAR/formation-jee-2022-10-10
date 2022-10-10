package com.bigcorp.booking.dao;

import javax.inject.Inject;

import org.apache.openejb.testing.SingleApplicationComposerRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SingleApplicationComposerRunner.class)
public class RestaurantTypeDaoTest {

	@Inject
	protected RestaurantTypeDao restaurantTypeDao;

	@Test
	public void testFind() {
		restaurantTypeDao.findById(3l);
	}

}
