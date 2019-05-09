package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the chef_commissions database table.
 * 
 */
@Entity
@Table(name="chef_commissions")
@NamedQuery(name="ChefCommission.findAll", query="SELECT c FROM ChefCommission c")
public class ChefCommission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="comm_mapping_key")
	private Long commMappingKey;

	@Column(name="base_cost")
	private BigDecimal baseCost;

	@Column(name="extra_time_per_extra_dish")
	private BigDecimal extraTimePerExtraDish;

	@Column(name="other_offset")
	private BigDecimal otherOffset;

	@Column(name="per_extra_accompaniment")
	private BigDecimal perExtraAccompaniment;

	@Column(name="per_extra_dessert_cost")
	private BigDecimal perExtraDessertCost;

	@Column(name="per_extra_main_course_cost")
	private BigDecimal perExtraMainCourseCost;

	@Column(name="per_extra_person_cost")
	private BigDecimal perExtraPersonCost;

	@Column(name="per_extra_starter_cost")
	private BigDecimal perExtraStarterCost;

	@Column(name="rating_offset")
	private BigDecimal ratingOffset;

	//bi-directional many-to-one association to ChefDetail
	@ManyToOne
	@JoinColumn(name="chef_id")
	private ChefDetail chefDetail;

	public ChefCommission() {
	}

	public Long getCommMappingKey() {
		return this.commMappingKey;
	}

	public void setCommMappingKey(Long commMappingKey) {
		this.commMappingKey = commMappingKey;
	}

	public BigDecimal getBaseCost() {
		return this.baseCost;
	}

	public void setBaseCost(BigDecimal baseCost) {
		this.baseCost = baseCost;
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

	public BigDecimal getPerExtraAccompaniment() {
		return this.perExtraAccompaniment;
	}

	public void setPerExtraAccompaniment(BigDecimal perExtraAccompaniment) {
		this.perExtraAccompaniment = perExtraAccompaniment;
	}

	public BigDecimal getPerExtraDessertCost() {
		return this.perExtraDessertCost;
	}

	public void setPerExtraDessertCost(BigDecimal perExtraDessertCost) {
		this.perExtraDessertCost = perExtraDessertCost;
	}

	public BigDecimal getPerExtraMainCourseCost() {
		return this.perExtraMainCourseCost;
	}

	public void setPerExtraMainCourseCost(BigDecimal perExtraMainCourseCost) {
		this.perExtraMainCourseCost = perExtraMainCourseCost;
	}

	public BigDecimal getPerExtraPersonCost() {
		return this.perExtraPersonCost;
	}

	public void setPerExtraPersonCost(BigDecimal perExtraPersonCost) {
		this.perExtraPersonCost = perExtraPersonCost;
	}

	public BigDecimal getPerExtraStarterCost() {
		return this.perExtraStarterCost;
	}

	public void setPerExtraStarterCost(BigDecimal perExtraStarterCost) {
		this.perExtraStarterCost = perExtraStarterCost;
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