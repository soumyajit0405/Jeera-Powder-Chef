package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ingredient_appliance_mappings database table.
 * 
 */
@Entity
@Table(name="ingredient_appliance_mappings")
@NamedQuery(name="IngredientApplianceMapping.findAll", query="SELECT i FROM IngredientApplianceMapping i")
public class IngredientApplianceMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="app_mapping_id")
	private Long appMappingId;

	//bi-directional many-to-one association to AllIngredient
	@ManyToOne
	@JoinColumn(name="ingredient_id")
	private AllIngredient allIngredient;

	//bi-directional many-to-one association to SpecialAppliance
	@ManyToOne
	@JoinColumn(name="sp_app_id")
	private SpecialAppliance specialAppliance;

	public IngredientApplianceMapping() {
	}

	public Long getAppMappingId() {
		return this.appMappingId;
	}

	public void setAppMappingId(Long appMappingId) {
		this.appMappingId = appMappingId;
	}

	public AllIngredient getAllIngredient() {
		return this.allIngredient;
	}

	public void setAllIngredient(AllIngredient allIngredient) {
		this.allIngredient = allIngredient;
	}

	public SpecialAppliance getSpecialAppliance() {
		return this.specialAppliance;
	}

	public void setSpecialAppliance(SpecialAppliance specialAppliance) {
		this.specialAppliance = specialAppliance;
	}

}