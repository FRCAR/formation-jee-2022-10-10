package com.bigcorp.booking.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.openejb.testing.SingleApplicationComposerRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bigcorp.booking.model.Restaurant;
import com.bigcorp.booking.model.RestaurantType;

@RunWith(SingleApplicationComposerRunner.class)
public class RestaurantServiceTest {

	@Inject
	protected RestaurantService restaurantService;

	@Inject
	protected RestaurantTypeService restaurantTypeService;

	@Test
	public void testFind() {
		restaurantService.findById(3l);
	}

	@Test
	public void testSave() {
		Restaurant restaurant = new Restaurant();
		restaurant.setName("Mon beau restaurant");
		Restaurant restaurantSaved = this.restaurantService.save(restaurant);
		Assert.assertNotNull(restaurantService.findById(restaurantSaved.getId()));
	}

	@Test
	public void testDelete() {
		Restaurant restaurant = new Restaurant();
		restaurant.setName("Mon beau restaurant");
		Restaurant restaurantSaved = this.restaurantService.save(restaurant);
		Assert.assertNotNull(this.restaurantService.findById(restaurantSaved.getId()));
		this.restaurantService.delete(restaurantSaved);
		Assert.assertNull(this.restaurantService.findById(restaurantSaved.getId()));
	}

	@Test
	public void testFindByName() {
		Restaurant restaurant = new Restaurant();
		String name = "Mon beau restaurant";
		restaurant.setName(name);
		Restaurant restaurantSaved = this.restaurantService.save(restaurant);

		List<Restaurant> restaurants = this.restaurantService.findByName(name);
		Assert.assertFalse(restaurants.isEmpty());
	}

	@Test
	public void testFindWithType() {
		Restaurant restaurant = new Restaurant();
		restaurant.setName("Mc Do avec cadeaux");

		RestaurantType restaurantType = new RestaurantType();
		restaurantType.setName("Restaurant local");
		restaurantType = this.restaurantTypeService.save(restaurantType);

		restaurant.setRestaurantType(restaurantType);
		restaurant = this.restaurantService.save(restaurant);

		List<Restaurant> loadedRestaurants = this.restaurantService
					.findWithTypeByName(restaurant.getName());
		Restaurant restaurantWithType = loadedRestaurants.get(0);
		Assert.assertEquals(restaurantType.getName(), restaurantWithType.getRestaurantType().getName()); 
	}
	


	@Test
	public void testFindWithTypeById() {
		//Création des entités
		Restaurant restaurant = new Restaurant();
		restaurant.setName("Mc Do avec cadeaux");

		RestaurantType restaurantType = new RestaurantType();
		restaurantType.setName("Restaurant local");
		restaurantType = this.restaurantTypeService.save(restaurantType);

		restaurant.setRestaurantType(restaurantType);
		restaurant = this.restaurantService.save(restaurant);

		//Récupération du graphe d'objets Restaurant -> RestaurantType à partir de l'identifiant
		//du restaurant
		Restaurant restaurantWithRestaurantType = this.restaurantService.findWithTypeById(restaurant.getId());
		Assert.assertNotNull(restaurantWithRestaurantType);
		Assert.assertNotNull(restaurantWithRestaurantType.getRestaurantType());
		Assert.assertNotNull("Restaurant local", restaurantWithRestaurantType.getRestaurantType().getName() );
		
	}

}
