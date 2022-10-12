package com.bigcorp.booking.service;

import javax.inject.Inject;

import org.apache.openejb.testing.SingleApplicationComposerRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bigcorp.booking.model.Restaurant;
import com.bigcorp.booking.model.RestaurantType;

@RunWith(SingleApplicationComposerRunner.class)
public class RestaurantTypeServiceTest {

	@Inject
	protected RestaurantTypeService restaurantTypeService;

	@Inject
	protected RestaurantService restaurantService;

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
	
	
	@Test
	public void testFindWithRestaurantsTypeById() {

		//Création du type
		RestaurantType restaurantType = new RestaurantType();
		restaurantType.setName("Restaurant local");
		restaurantType = this.restaurantTypeService.save(restaurantType);

		//Création d'un premier restaurant rattaché au type
		Restaurant restaurant1 = new Restaurant();
		restaurant1.setName("Mc Do avec cadeaux");
		restaurant1.setRestaurantType(restaurantType);
		restaurant1 = this.restaurantService.save(restaurant1);

		//Création d'un deuxième restaurant rattaché au type
		Restaurant restaurant2 = new Restaurant();
		restaurant2.setName("Mc Do sans cadeaux");
		restaurant2.setRestaurantType(restaurantType);
		restaurant2 = this.restaurantService.save(restaurant2);

		//Récupération du graphe d'objets RestaurantType -> Restaurant à partir de l'identifiant
		//du restaurantType
		RestaurantType restaurantTypeWithRestaurants = this.restaurantTypeService.findWithRestaurantsById(restaurantType.getId());
		Assert.assertNotNull(restaurantTypeWithRestaurants);
		Assert.assertEquals(2, restaurantTypeWithRestaurants.getRestaurants().size());
		
	}

}
