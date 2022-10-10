package com.bigcorp.booking.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bigcorp.booking.dao.RestaurantDao;

@Stateless
public class RestaurantService {

	@Inject
	protected RestaurantDao restaurantDao;

	public RestaurantDao getRestaurantDao() {
		return restaurantDao;
	}

	public void setRestaurantDao(RestaurantDao restaurantDao) {
		this.restaurantDao = restaurantDao;
	}

}
