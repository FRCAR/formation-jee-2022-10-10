
package com.bigcorp.booking.model;

import java.time.LocalDateTime;

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
	private MonEnum monEnum;

	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name = "RESTAURANT_TYPE_ID")
	private RestaurantType restaurantType;

	private Long monLong;

	private Boolean active;

	@Column(nullable = false)
	private LocalDateTime openDate = LocalDateTime.now();

	public RestaurantType getRestaurantType() {
		return restaurantType;
	}

	public void setRestaurantType(RestaurantType restaurantType) {
		this.restaurantType = restaurantType;
	}

	public MonEnum getMonEnum() {
		return monEnum;
	}

	public void setMonEnum(MonEnum monEnum) {
		this.monEnum = monEnum;
	}

	public Long getMonLong() {
		return monLong;
	}

	public void setMonLong(Long monLong) {
		this.monLong = monLong;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public LocalDateTime getOpenDate() {
		return openDate;
	}

	public void setOpenDate(LocalDateTime openDate) {
		this.openDate = openDate;
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

}