package com.bigcorp.booking.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bigcorp.booking.model.RestaurantType;
import com.bigcorp.booking.service.RestaurantTypeService;

@Named
@Path("/restaurant-types")
public class RestaurantTypeRestService {

	@Inject
	RestaurantTypeService restaurantTypeService;

	@GET
	@Path("/{monParamId}")
	@Produces("application/json")
	public RestaurantType getRestaurantById(@PathParam("monParamId") Long id) {
		//Le path de ce truc est http://path-vers-le-serveur/rest/v1/restaurant-types/12
		RestaurantType restaurantType = this.restaurantTypeService.findById(id);
		if(restaurantType == null) {
			throw new NotFoundException("Heyy!! Je connais pas ce restau");
		}
		return restaurantType;
	}
	
	@DELETE
	@Path("/{monParamId}")
	public void deleteRestaurantById(@PathParam("monParamId") Long id) {
		//Le path de ce truc est http://path-vers-le-serveur/rest/v1/restaurant-types/12
		if(!this.restaurantTypeService.delete(id)) {
			throw new NotFoundException("Heyy!! Je connais pas ce restau");			
		}
		return;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
    public RestaurantType postRestaurant(RestaurantType restaurantType) {
    	if(restaurantType == null) {
    		return null;
    	}
        return this.restaurantTypeService.save(restaurantType);
    }

}













