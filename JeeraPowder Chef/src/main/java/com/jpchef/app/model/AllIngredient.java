package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the all_ingredients database table.
 * 
 */
@Entity
@Table(name="all_ingredients")
@NamedQuery(name="AllIngredient.findAll", query="SELECT a FROM AllIngredient a")
public class AllIngredient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ingredient_id")
	private Long ingredientId;

	@Column(name="average_cost_per_unit")
	private BigDecimal averageCostPerUnit;

	private String description;

	@Column(name="ingredient_name")
	private String ingredientName;

	private Boolean needsmicrowaveflag;

	private Boolean needsnonstickcookwareflag;

	private Boolean needsrefrigeratorflag;

	@Column(name="per_person_amount")
	private BigDecimal perPersonAmount;

	private String unit;

	//bi-directional many-to-one association to DishIngredientMapping
	@OneToMany(mappedBy="allIngredient")
	private List<DishIngredientMapping> dishIngredientMappings;

	//bi-directional many-to-one association to IngredientApplianceMapping
	@OneToMany(mappedBy="allIngredient")
	private List<IngredientApplianceMapping> ingredientApplianceMappings;

	public AllIngredient() {
	}

	public Long getIngredientId() {
		return this.ingredientId;
	}

	public void setIngredientId(Long ingredientId) {
		this.ingredientId = ingredientId;
	}

	public BigDecimal getAverageCostPerUnit() {
		return this.averageCostPerUnit;
	}

	public void setAverageCostPerUnit(BigDecimal averageCostPerUnit) {
		this.averageCostPerUnit = averageCostPerUnit;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIngredientName() {
		return this.ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public Boolean getNeedsmicrowaveflag() {
		return this.needsmicrowaveflag;
	}

	public void setNeedsmicrowaveflag(Boolean needsmicrowaveflag) {
		this.needsmicrowaveflag = needsmicrowaveflag;
	}

	public Boolean getNeedsnonstickcookwareflag() {
		return this.needsnonstickcookwareflag;
	}

	public void setNeedsnonstickcookwareflag(Boolean needsnonstickcookwareflag) {
		this.needsnonstickcookwareflag = needsnonstickcookwareflag;
	}

	public Boolean getNeedsrefrigeratorflag() {
		return this.needsrefrigeratorflag;
	}

	public void setNeedsrefrigeratorflag(Boolean needsrefrigeratorflag) {
		this.needsrefrigeratorflag = needsrefrigeratorflag;
	}

	public BigDecimal getPerPersonAmount() {
		return this.perPersonAmount;
	}

	public void setPerPersonAmount(BigDecimal perPersonAmount) {
		this.perPersonAmount = perPersonAmount;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public List<DishIngredientMapping> getDishIngredientMappings() {
		return this.dishIngredientMappings;
	}

	public void setDishIngredientMappings(List<DishIngredientMapping> dishIngredientMappings) {
		this.dishIngredientMappings = dishIngredientMappings;
	}

	public DishIngredientMapping addDishIngredientMapping(DishIngredientMapping dishIngredientMapping) {
		getDishIngredientMappings().add(dishIngredientMapping);
		dishIngredientMapping.setAllIngredient(this);

		return dishIngredientMapping;
	}

	public DishIngredientMapping removeDishIngredientMapping(DishIngredientMapping dishIngredientMapping) {
		getDishIngredientMappings().remove(dishIngredientMapping);
		dishIngredientMapping.setAllIngredient(null);

		return dishIngredientMapping;
	}

	public List<IngredientApplianceMapping> getIngredientApplianceMappings() {
		return this.ingredientApplianceMappings;
	}

	public void setIngredientApplianceMappings(List<IngredientApplianceMapping> ingredientApplianceMappings) {
		this.ingredientApplianceMappings = ingredientApplianceMappings;
	}

	public IngredientApplianceMapping addIngredientApplianceMapping(IngredientApplianceMapping ingredientApplianceMapping) {
		getIngredientApplianceMappings().add(ingredientApplianceMapping);
		ingredientApplianceMapping.setAllIngredient(this);

		return ingredientApplianceMapping;
	}

	public IngredientApplianceMapping removeIngredientApplianceMapping(IngredientApplianceMapping ingredientApplianceMapping) {
		getIngredientApplianceMappings().remove(ingredientApplianceMapping);
		ingredientApplianceMapping.setAllIngredient(null);

		return ingredientApplianceMapping;
	}

}