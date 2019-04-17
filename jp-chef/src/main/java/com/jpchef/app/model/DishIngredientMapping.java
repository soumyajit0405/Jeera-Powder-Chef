package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dish_ingredient_mapping database table.
 * 
 */
@Entity
@Table(name="dish_ingredient_mapping")
@NamedQuery(name="DishIngredientMapping.findAll", query="SELECT d FROM DishIngredientMapping d")
public class DishIngredientMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ingredient_mapping_id")
	private Long ingredientMappingId;

	//bi-directional many-to-one association to AllDishe
	@ManyToOne
	@JoinColumn(name="dish_id")
	private AllDishe allDishe;

	//bi-directional many-to-one association to AllIngredient
	@ManyToOne
	@JoinColumn(name="ingredient_id")
	private AllIngredient allIngredient;

	public DishIngredientMapping() {
	}

	public Long getIngredientMappingId() {
		return this.ingredientMappingId;
	}

	public void setIngredientMappingId(Long ingredientMappingId) {
		this.ingredientMappingId = ingredientMappingId;
	}

	public AllDishe getAllDishe() {
		return this.allDishe;
	}

	public void setAllDishe(AllDishe allDishe) {
		this.allDishe = allDishe;
	}

	public AllIngredient getAllIngredient() {
		return this.allIngredient;
	}

	public void setAllIngredient(AllIngredient allIngredient) {
		this.allIngredient = allIngredient;
	}

}