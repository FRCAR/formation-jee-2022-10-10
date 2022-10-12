package com.bigcorp.booking.model;

import javax.persistence.Entity;

@Entity
public class Pizzeria extends AbstractRestaurant {

	private String pizzaName;

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	
	
	
}
