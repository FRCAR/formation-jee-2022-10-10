package com.bigcorp.booking.rest;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bigcorp.booking.model.RestaurantType;

@Named
@Path("/bookings")
public class BookingRestService {
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
    public BookingPojo post(BookingPojo bookingPojo) {
		if(bookingPojo.getId() == null) {
			bookingPojo.setId((long)(Math.random()*100));
		}
    	return bookingPojo;
    }

}













