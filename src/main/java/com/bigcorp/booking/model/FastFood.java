package com.bigcorp.booking.model;

import javax.persistence.Entity;

@Entity
public class FastFood extends AbstractRestaurant {

	private String burgerName;

	public String getBurgerName() {
		return burgerName;
	}

	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}
	
	
}
