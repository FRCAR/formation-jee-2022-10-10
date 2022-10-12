package com.bigcorp.booking.service;

import java.time.LocalDate;

import javax.inject.Inject;

import org.apache.openejb.testing.SingleApplicationComposerRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bigcorp.booking.model.Booking;
import com.bigcorp.booking.model.Restaurant;

@RunWith(SingleApplicationComposerRunner.class)
public class BookingServiceTest {

	@Inject
	protected BookingService bookingService;

	@Inject
	protected RestaurantService restaurantService;


	@Test
	public void testSave() {
		Restaurant restaurant = new Restaurant();
		restaurant.setName("La bonne auberge");
		restaurant = this.restaurantService.save(restaurant);

		Booking booking = new Booking();
		booking.setName("Premier booking");
		booking.setDate(LocalDate.of(2029, 3, 10));
		booking.associateWith(restaurant);
		booking.setSize(3);
		booking = this.bookingService.save(booking);
		Assert.assertNotNull(bookingService.findById(booking.getId()));
	}

	@Test
	public void testDelete() {
		Restaurant restaurant = new Restaurant();
		restaurant.setName("La bonne auberge");
		restaurant = this.restaurantService.save(restaurant);

		Booking booking = new Booking();
		booking.setName("Premier booking");
		booking.setDate(LocalDate.of(2029, 3, 10));
		booking.associateWith(restaurant);
		booking.setSize(3);
		booking = this.bookingService.save(booking);
		Assert.assertNotNull(this.bookingService.findById(booking.getId()));
		this.bookingService.delete(booking);
		Assert.assertNull(this.bookingService.findById(booking.getId()));
	}

	@Test
	public void testFindWithCriteria() {
		Restaurant restaurant = new Restaurant();
		restaurant.setName("La bonne auberge");
		restaurant = this.restaurantService.save(restaurant);

		Booking booking = new Booking();
		booking.setName("Premier booking");
		booking.setDate(LocalDate.of(2044, 3, 10));
		booking.associateWith(restaurant);
		booking.setSize(3);
		booking = this.bookingService.save(booking);
		Assert.assertEquals(1,
				this.bookingService.findByRestaurantAndDate(booking.getRestaurant().getId(), booking.getDate()).size());
		Assert.assertEquals(1, this.bookingService.findByRestaurantAndDate(null, booking.getDate()).size());
		Assert.assertEquals(1, this.bookingService.findByRestaurantAndDate(booking.getRestaurant().getId(), null).size());
		Assert.assertFalse(this.bookingService.findByRestaurantAndDate(null, null).isEmpty());
		Assert.assertEquals(0, this.bookingService.findByRestaurantAndDate(-45l, null).size());
		Assert.assertEquals(0,
				this.bookingService.findByRestaurantAndDate(null, booking.getDate().plusDays(1)).size());

	}

}
