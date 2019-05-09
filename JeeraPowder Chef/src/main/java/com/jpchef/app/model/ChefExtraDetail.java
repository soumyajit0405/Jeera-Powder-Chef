package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the chef_extra_details database table.
 * 
 */
@Entity
@Table(name="chef_extra_details")
@NamedQuery(name="ChefExtraDetail.findAll", query="SELECT c FROM ChefExtraDetail c")
public class ChefExtraDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="pref_travel_distance")
	private BigDecimal _prefTravelDistance;

	@Column(name="aadhar_number")
	private String aadharNumber;

	@Column(name="address_line_one")
	private String addressLineOne;

	@Column(name="address_line_two")
	private String addressLineTwo;

	@Column(name="alt_phn_number")
	private String altPhnNumber;
	
	@Id
	@Column(name="chef_extra_detail_id")
	private Long chefExtraDetailId;

	private String city;

	private String locality;

	@Column(name="max_travel_distance")
	private BigDecimal maxTravelDistance;

	private String pan;

	@Column(name="per_km_travel_cost")
	private BigDecimal perKmTravelCost;

	private String region;

	@Column(name="verification_status")
	private Integer verificationStatus;

	private String zone;

	//bi-directional many-to-one association to ChefDetail
	@ManyToOne
	@JoinColumn(name="chef_id")
	private ChefDetail chefDetail;

	public ChefExtraDetail() {
	}

	public BigDecimal get_prefTravelDistance() {
		return this._prefTravelDistance;
	}

	public void set_prefTravelDistance(BigDecimal _prefTravelDistance) {
		this._prefTravelDistance = _prefTravelDistance;
	}

	public String getAadharNumber() {
		return this.aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getAddressLineOne() {
		return this.addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return this.addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getAltPhnNumber() {
		return this.altPhnNumber;
	}

	public void setAltPhnNumber(String altPhnNumber) {
		this.altPhnNumber = altPhnNumber;
	}

	public Long getChefExtraDetailId() {
		return this.chefExtraDetailId;
	}

	public void setChefExtraDetailId(Long chefExtraDetailId) {
		this.chefExtraDetailId = chefExtraDetailId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocality() {
		return this.locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public BigDecimal getMaxTravelDistance() {
		return this.maxTravelDistance;
	}

	public void setMaxTravelDistance(BigDecimal maxTravelDistance) {
		this.maxTravelDistance = maxTravelDistance;
	}

	public String getPan() {
		return this.pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public BigDecimal getPerKmTravelCost() {
		return this.perKmTravelCost;
	}

	public void setPerKmTravelCost(BigDecimal perKmTravelCost) {
		this.perKmTravelCost = perKmTravelCost;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getVerificationStatus() {
		return this.verificationStatus;
	}

	public void setVerificationStatus(Integer verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getZone() {
		return this.zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public ChefDetail getChefDetail() {
		return this.chefDetail;
	}

	public void setChefDetail(ChefDetail chefDetail) {
		this.chefDetail = chefDetail;
	}

}