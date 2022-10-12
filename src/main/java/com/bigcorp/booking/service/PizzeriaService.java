package com.bigcorp.booking.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bigcorp.booking.dao.PizzeriaDao;
import com.bigcorp.booking.model.Pizzeria;

@Stateless
public class PizzeriaService {

	@Inject
	protected PizzeriaDao pizzeriaDao;
	
	public Pizzeria save(Pizzeria pizzeria) {
		return this.pizzeriaDao.merge(pizzeria);
	}

}
