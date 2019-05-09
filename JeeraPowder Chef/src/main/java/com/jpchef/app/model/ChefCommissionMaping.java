package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the chef_commission_mapings database table.
 * 
 */
@Entity
@Table(name="chef_commission_mapings")
@NamedQuery(name="ChefCommissionMaping.findAll", query="SELECT c FROM ChefCommissionMaping c")
public class ChefCommissionMaping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="comm_mapping_key")
	private Integer commMappingKey;

	@Column(name="base_cost")
	private BigDecimal baseCost;

	@Column(name="extra_accompaniment")
	private BigDecimal extraAccompaniment;

	@Column(name="extra_dessert_cost")
	private BigDecimal extraDessertCost;

	@Column(name="extra_main_course_cost")
	private BigDecimal extraMainCourseCost;

	@Column(name="extra_person_cost")
	private BigDecimal extraPersonCost;

	@Column(name="extra_starter_cost")
	private BigDecimal extraStarterCost;

	@Column(name="extra_time_per_extra_dish")
	private BigDecimal extraTimePerExtraDish;

	@Column(name="other_offset")
	private BigDecimal otherOffset;

	@Column(name="rating_offset")
	private BigDecimal ratingOffset;

	//bi-directional many-to-one association to ChefDetail
	@ManyToOne
	@JoinColumn(name="chef_id")
	private ChefDetail chefDetail;

	public ChefCommissionMaping() {
	}

	public Integer getCommMappingKey() {
		return this.commMappingKey;
	}

	public void setCommMappingKey(Integer commMappingKey) {
		this.commMappingKey = commMappingKey;
	}

	public BigDecimal getBaseCost() {
		return this.baseCost;
	}

	public void setBaseCost(BigDecimal baseCost) {
		this.baseCost = baseCost;
	}

	public BigDecimal getExtraAccompaniment() {
		return this.extraAccompaniment;
	}

	public void setExtraAccompaniment(BigDecimal extraAccompaniment) {
		this.extraAccompaniment = extraAccompaniment;
	}

	public BigDecimal getExtraDessertCost() {
		return this.extraDessertCost;
	}

	public void setExtraDessertCost(BigDecimal extraDessertCost) {
		this.extraDessertCost = extraDessertCost;
	}

	public BigDecimal getExtraMainCourseCost() {
		return this.extraMainCourseCost;
	}

	public void setExtraMainCourseCost(BigDecimal extraMainCourseCost) {
		this.extraMainCourseCost = extraMainCourseCost;
	}

	public BigDecimal getExtraPersonCost() {
		return this.extraPersonCost;
	}

	public void setExtraPersonCost(BigDecimal extraPersonCost) {
		this.extraPersonCost = extraPersonCost;
	}

	public BigDecimal getExtraStarterCost() {
		return this.extraStarterCost;
	}

	public void setExtraStarterCost(BigDecimal extraStarterCost) {
		this.extraStarterCost = extraStarterCost;
	}

	public BigDecimal getExtraTimePerExtraDish() {
		return this.extraTimePerExtraDish;
	}

	public void setExtraTimePerExtraDish(BigDecimal extraTimePerExtraDish) {
		this.extraTimePerExtraDish = extraTimePerExtraDish;
	}

	public BigDecimal getOtherOffset() {
		return this.otherOffset;
	}

	public void setOtherOffset(BigDecimal otherOffset) {
		this.otherOffset = otherOffset;
	}

	public BigDecimal getRatingOffset() {
		return this.ratingOffset;
	}

	public void setRatingOffset(BigDecimal ratingOffset) {
		this.ratingOffset = ratingOffset;
	}

	public ChefDetail getChefDetail() {
		return this.chefDetail;
	}

	public void setChefDetail(ChefDetail chefDetail) {
		this.chefDetail = chefDetail;
	}

}