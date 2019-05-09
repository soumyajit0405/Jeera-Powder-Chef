package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the chef_dish_mappings database table.
 * 
 */
@Entity
@Table(name="chef_dish_mappings")
@NamedQuery(name="ChefDishMapping.findAll", query="SELECT c FROM ChefDishMapping c")
public class ChefDishMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dish_mapping_id")
	private Long dishMappingId;

	@Column(name="preparation_score")
	private Integer preparationScore;

	//bi-directional many-to-one association to AllDishe
	@ManyToOne
	@JoinColumn(name="dish_id")
	private AllDishe allDishe;

	//bi-directional many-to-one association to ChefDetail
	@ManyToOne
	@JoinColumn(name="chef_id")
	private ChefDetail chefDetail;

	public ChefDishMapping() {
	}

	public Long getDishMappingId() {
		return this.dishMappingId;
	}

	public void setDishMappingId(Long dishMappingId) {
		this.dishMappingId = dishMappingId;
	}

	public Integer getPreparationScore() {
		return this.preparationScore;
	}

	public void setPreparationScore(Integer preparationScore) {
		this.preparationScore = preparationScore;
	}

	public AllDishe getAllDishe() {
		return this.allDishe;
	}

	public void setAllDishe(AllDishe allDishe) {
		this.allDishe = allDishe;
	}

	public ChefDetail getChefDetail() {
		return this.chefDetail;
	}

	public void setChefDetail(ChefDetail chefDetail) {
		this.chefDetail = chefDetail;
	}

}