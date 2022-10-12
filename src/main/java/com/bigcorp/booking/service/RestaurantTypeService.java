package com.bigcorp.booking.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import com.bigcorp.booking.dao.RestaurantTypeDao;
import com.bigcorp.booking.model.Restaurant;
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

	@TransactionAttribute
	public boolean delete(Long id) {
		RestaurantType persistedRestaurantType = this.restaurantTypeDao.findById(RestaurantType.class, id);
		if(persistedRestaurantType == null) {
			return false;
		}
		this.restaurantTypeDao.remove(persistedRestaurantType);
		return true;
	}
	
	public RestaurantType findWithRestaurantsById(Long id) {
		return this.restaurantTypeDao.findWithRestaurantsById(id);
	}

}
