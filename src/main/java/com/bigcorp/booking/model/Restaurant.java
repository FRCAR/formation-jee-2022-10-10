
package com.bigcorp.booking.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "myFirstquery", query = "select r from Restaurant r")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	private String name;

	@Enumerated(EnumType.STRING)
	private PriceCategory priceCategory;

	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name = "RESTAURANT_TYPE_ID")
	private RestaurantType restaurantType;

	private Boolean active;
	
	private Set<Booking> bookings = new HashSet<>();
	
	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}
	
	public RestaurantType getRestaurantType() {
		return restaurantType;
	}

	public void setRestaurantType(RestaurantType restaurantType) {
		this.restaurantType = restaurantType;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PriceCategory getPriceCategory() {
		return priceCategory;
	}

	public void setPriceCategory(PriceCategory priceCategory) {
		this.priceCategory = priceCategory;
	}

	public void associateWith(RestaurantType restaurantType) {
		this.restaurantType = restaurantType;
		if(restaurantType == null) {
			return;
		}
		this.restaurantType.getRestaurants().add(this);
	}
	
	public void associateWith(Booking booking) {
		if(booking != null) {
			this.bookings.add(booking);
			booking.setRestaurant(this);
		}
	}

}