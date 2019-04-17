package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the special_appliances database table.
 * 
 */
@Entity
@Table(name="special_appliances")
@NamedQuery(name="SpecialAppliance.findAll", query="SELECT s FROM SpecialAppliance s")
public class SpecialAppliance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sp_app_id")
	private Long spAppId;

	@Column(name="appliance_name")
	private String applianceName;

	//bi-directional many-to-one association to IngredientApplianceMapping
	@OneToMany(mappedBy="specialAppliance")
	private List<IngredientApplianceMapping> ingredientApplianceMappings;

	public SpecialAppliance() {
	}

	public Long getSpAppId() {
		return this.spAppId;
	}

	public void setSpAppId(Long spAppId) {
		this.spAppId = spAppId;
	}

	public String getApplianceName() {
		return this.applianceName;
	}

	public void setApplianceName(String applianceName) {
		this.applianceName = applianceName;
	}

	public List<IngredientApplianceMapping> getIngredientApplianceMappings() {
		return this.ingredientApplianceMappings;
	}

	public void setIngredientApplianceMappings(List<IngredientApplianceMapping> ingredientApplianceMappings) {
		this.ingredientApplianceMappings = ingredientApplianceMappings;
	}

	public IngredientApplianceMapping addIngredientApplianceMapping(IngredientApplianceMapping ingredientApplianceMapping) {
		getIngredientApplianceMappings().add(ingredientApplianceMapping);
		ingredientApplianceMapping.setSpecialAppliance(this);

		return ingredientApplianceMapping;
	}

	public IngredientApplianceMapping removeIngredientApplianceMapping(IngredientApplianceMapping ingredientApplianceMapping) {
		getIngredientApplianceMappings().remove(ingredientApplianceMapping);
		ingredientApplianceMapping.setSpecialAppliance(null);

		return ingredientApplianceMapping;
	}

}