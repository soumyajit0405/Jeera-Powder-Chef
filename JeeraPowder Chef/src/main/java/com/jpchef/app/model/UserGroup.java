package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user_groups database table.
 * 
 */
@Entity
@Table(name="user_groups")
@NamedQuery(name="UserGroup.findAll", query="SELECT u FROM UserGroup u")
public class UserGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_group_id")
	private Long userGroupId;

	@Column(name="end_time")
	private Timestamp endTime;

	@Column(name="start_time")
	private Timestamp startTime;

	private Boolean status;

	@Column(name="user_group_name")
	private String userGroupName;

	//bi-directional many-to-one association to AllCoupon
	@OneToMany(mappedBy="userGroup")
	private List<AllCoupon> allCoupons;

	//bi-directional many-to-one association to AllDishRating
	@OneToMany(mappedBy="userGroup")
	private List<AllDishRating> allDishRatings;

	//bi-directional many-to-one association to UserGroupMapping
	@OneToMany(mappedBy="userGroup")
	private List<UserGroupMapping> userGroupMappings;

	public UserGroup() {
	}

	public Long getUserGroupId() {
		return this.userGroupId;
	}

	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getUserGroupName() {
		return this.userGroupName;
	}

	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
	}

	public List<AllCoupon> getAllCoupons() {
		return this.allCoupons;
	}

	public void setAllCoupons(List<AllCoupon> allCoupons) {
		this.allCoupons = allCoupons;
	}

	public AllCoupon addAllCoupon(AllCoupon allCoupon) {
		getAllCoupons().add(allCoupon);
		allCoupon.setUserGroup(this);

		return allCoupon;
	}

	public AllCoupon removeAllCoupon(AllCoupon allCoupon) {
		getAllCoupons().remove(allCoupon);
		allCoupon.setUserGroup(null);

		return allCoupon;
	}

	public List<AllDishRating> getAllDishRatings() {
		return this.allDishRatings;
	}

	public void setAllDishRatings(List<AllDishRating> allDishRatings) {
		this.allDishRatings = allDishRatings;
	}

	public AllDishRating addAllDishRating(AllDishRating allDishRating) {
		getAllDishRatings().add(allDishRating);
		allDishRating.setUserGroup(this);

		return allDishRating;
	}

	public AllDishRating removeAllDishRating(AllDishRating allDishRating) {
		getAllDishRatings().remove(allDishRating);
		allDishRating.setUserGroup(null);

		return allDishRating;
	}

	public List<UserGroupMapping> getUserGroupMappings() {
		return this.userGroupMappings;
	}

	public void setUserGroupMappings(List<UserGroupMapping> userGroupMappings) {
		this.userGroupMappings = userGroupMappings;
	}

	public UserGroupMapping addUserGroupMapping(UserGroupMapping userGroupMapping) {
		getUserGroupMappings().add(userGroupMapping);
		userGroupMapping.setUserGroup(this);

		return userGroupMapping;
	}

	public UserGroupMapping removeUserGroupMapping(UserGroupMapping userGroupMapping) {
		getUserGroupMappings().remove(userGroupMapping);
		userGroupMapping.setUserGroup(null);

		return userGroupMapping;
	}

}