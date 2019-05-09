package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;

import org.postgresql.geometric.PGpoint;


/**
 * The persistent class for the user_saved_addresses database table.
 * 
 */
@Entity
@Table(name="user_saved_addresses")
@NamedQuery(name="UserSavedAddress.findAll", query="SELECT u FROM UserSavedAddress u")
public class UserSavedAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="saved_address_id")
	private Long savedAddressId;

	@Column(name="address_line_one")
	private String addressLineOne;

	@Column(name="address_line_three")
	private String addressLineThree;

	@Column(name="address_line_two")
	private String addressLineTwo;

	@Column(name="address_name")
	private String addressName;

	@Column(name="user_location")
	private PGpoint userLocation;

	//bi-directional many-to-one association to UserProfile
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserProfile userProfile;

	public UserSavedAddress() {
	}

	public Long getSavedAddressId() {
		return this.savedAddressId;
	}

	public void setSavedAddressId(Long savedAddressId) {
		this.savedAddressId = savedAddressId;
	}

	public String getAddressLineOne() {
		return this.addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineThree() {
		return this.addressLineThree;
	}

	public void setAddressLineThree(String addressLineThree) {
		this.addressLineThree = addressLineThree;
	}

	public String getAddressLineTwo() {
		return this.addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getAddressName() {
		return this.addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public PGpoint getUserLocation() {
		return this.userLocation;
	}

	public void setUserLocation(PGpoint userLocation) {
		this.userLocation = userLocation;
	}

	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

}