package com.bigcorp.booking.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import com.bigcorp.booking.dao.RestaurantDao;
import com.bigcorp.booking.model.Restaurant;

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

	@TransactionAttribute
	public Restaurant findById(long id) {
		return this.restaurantDao.findById(Restaurant.class, id);
	}

	@TransactionAttribute
	public Restaurant save(Restaurant restaurant) {
		return this.restaurantDao.merge(restaurant);
	}

	@TransactionAttribute
	public void delete(Restaurant restaurant) {
		Restaurant persistedRestaurant = this.restaurantDao.findById(Restaurant.class, restaurant.getId());
		this.restaurantDao.remove(persistedRestaurant);
	}

	public List<Restaurant> findByName(String name) {
		return this.restaurantDao.findByName(name);
	}

	public List<Restaurant> findWithTypeByName(String name) {
		return this.restaurantDao.findWithTypeByName(name);
	}

	/**
	 * 
	 * @param id
	 * @return Restaurant, attention peut être null.
	 */
	public Restaurant findWithTypeById(Long id) {
		return this.restaurantDao.findWithTypeById(id);
	}

}
