package com.bigcorp.booking.dao;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigcorp.booking.model.RestaurantType;

@Singleton
public class RestaurantTypeDao {

	@PersistenceContext
	protected EntityManager entityManager;

	public RestaurantType findById(Long id) {
		return this.entityManager.find(RestaurantType.class, id);
	}

}
