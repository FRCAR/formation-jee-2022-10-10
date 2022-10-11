package com.bigcorp.booking.dao;

import java.util.List;

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

	public RestaurantType save(RestaurantType restaurantType) {
		return this.entityManager.merge(restaurantType);
	}

	public RestaurantType findWithRestaurantsById(Long id) {
		List<RestaurantType> resultList = this.entityManager.createQuery(
				" select distinct rt  from RestaurantType rt "
				+ " left outer join fetch  rt.restaurants "
				+ " where rt.id = :idParam "
				, RestaurantType.class)
		.setParameter("idParam", id)
		.getResultList();
		if(resultList.isEmpty()) {
			return null;
		}
		//else...
		return resultList.get(0);
	}

}
