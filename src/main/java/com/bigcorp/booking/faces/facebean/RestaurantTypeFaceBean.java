package com.bigcorp.booking.faces.facebean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bigcorp.booking.faces.formbean.RestaurantTypeFormBean;
import com.bigcorp.booking.model.RestaurantType;
import com.bigcorp.booking.service.RestaurantTypeService;

@Named
@RequestScoped
public class RestaurantTypeFaceBean {
	
	@Inject
	private RestaurantTypeService restaurantTypeService;

	@Inject
	private RestaurantTypeFormBean restaurantTypeFormBean;
	
	private Long loadId;
	
	public Long getLoadId() {
		return loadId;
	}

	public void setLoadId(Long loadId) {
		this.loadId = loadId;
	}

	public String displayCreate() {
		return "restaurant-type";
	}
	
	public String getMaValeur() {
		return "chouette";
	}
	
	public String save() {
		RestaurantType entity = toEntity();
		RestaurantType savedEntity = this.restaurantTypeService.save(entity);
		return "restaurant-type?faces-redirect=true&id=" + savedEntity.getId();
	}
	
	public String cancel() {
		return "hello";
		
	}
	
	public void onLoad() {
		//récupérer l'id
		RestaurantType restaurantTypeWithId = this.restaurantTypeService.findById(this.loadId);
		if(restaurantTypeWithId == null) {
			return;
		}
		fromEntity(restaurantTypeWithId);
	}

	/**
	 * Transfers this.restaurantFormBean entity attributes.
	 * @return
	 */
	private RestaurantType toEntity() {
		RestaurantType entity = new RestaurantType();
		entity.setId(this.restaurantTypeFormBean.getId());
		entity.setName(this.restaurantTypeFormBean.getName());
		return entity;
	}
	
	/**
	 * Transfers entity attributes to this.restaurantFormBean attributes.
	 * @param entity
	 */
	private void fromEntity(RestaurantType entity) {
		this.restaurantTypeFormBean.setId(entity.getId());
		this.restaurantTypeFormBean.setName(entity.getName());
	}
	
	
	
	
	
	
	
	
	
	
	
}
