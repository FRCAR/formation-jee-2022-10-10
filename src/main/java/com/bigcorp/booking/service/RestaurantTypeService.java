package com.bigcorp.booking.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bigcorp.booking.dao.RestaurantTypeDao;
import com.bigcorp.booking.model.RestaurantType;

@Stateless
public class RestaurantTypeService {

	@Inject
	RestaurantTypeDao restaurantTypeDao;

	public RestaurantType findById(Long id) {
		return this.restaurantTypeDao.findById(id);
	}

	public RestaurantType save(RestaurantType restaurantType) {
		return this.restaurantTypeDao.save(restaurantType);
	}
	
	public RestaurantType findWithRestaurantsById(Long id) {
		return this.restaurantTypeDao.findWithRestaurantsById(id);
	}

}
