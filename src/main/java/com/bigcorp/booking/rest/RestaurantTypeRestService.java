package com.bigcorp.booking.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bigcorp.booking.model.RestaurantType;
import com.bigcorp.booking.service.RestaurantTypeService;

@Named
@Path("/restaurant-types")
@Produces("application/json")
public class RestaurantTypeRestService {

	@Inject
	RestaurantTypeService restaurantTypeService;

	@GET
	@Path("/{monParamId}")
	public RestaurantType getRestaurantById(@PathParam("monParamId") Long id) {
		//Le path de ce truc est http://path-vers-le-serveur/rest/v1/restaurant-types/12
		return this.restaurantTypeService.findById(id);
	}

}













