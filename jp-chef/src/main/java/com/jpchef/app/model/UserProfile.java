package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user_profiles database table.
 * 
 */
@Entity
@Table(name="user_profiles")
@NamedQuery(name="UserProfile.findAll", query="SELECT u FROM UserProfile u")
public class UserProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	private Long userId;

	@Column(name="full_name")
	private String fullName;

	@Column(name="login_auth_token")
	private Long loginAuthToken;

	@Column(name="login_mode")
	private Integer loginMode;

	@Column(name="mail_id")
	private String mailId;

	@Column(name="mail_verification_staus")
	private Boolean mailVerificationStaus;

	@Column(name="phone_number")
	private String phoneNumber;

	@Column(name="phone_number_verification_staus")
	private Boolean phoneNumberVerificationStaus;

	@Column(name="profile_image")
	private String profileImage;

	//bi-directional many-to-one association to BookingDetail
	@OneToMany(mappedBy="userProfile")
	private List<BookingDetail> bookingDetails;

	//bi-directional many-to-one association to UsedCoupon
	@OneToMany(mappedBy="userProfile")
	private List<UsedCoupon> usedCoupons;

	//bi-directional many-to-one association to UserGroupMapping
	@OneToMany(mappedBy="userProfile")
	private List<UserGroupMapping> userGroupMappings;

	//bi-directional many-to-one association to UserSavedAddress
	@OneToMany(mappedBy="userProfile")
	private List<UserSavedAddress> userSavedAddresses;

	public UserProfile() {
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getLoginAuthToken() {
		return this.loginAuthToken;
	}

	public void setLoginAuthToken(Long loginAuthToken) {
		this.loginAuthToken = loginAuthToken;
	}

	public Integer getLoginMode() {
		return this.loginMode;
	}

	public void setLoginMode(Integer loginMode) {
		this.loginMode = loginMode;
	}

	public String getMailId() {
		return this.mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public Boolean getMailVerificationStaus() {
		return this.mailVerificationStaus;
	}

	public void setMailVerificationStaus(Boolean mailVerificationStaus) {
		this.mailVerificationStaus = mailVerificationStaus;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Boolean getPhoneNumberVerificationStaus() {
		return this.phoneNumberVerificationStaus;
	}

	public void setPhoneNumberVerificationStaus(Boolean phoneNumberVerificationStaus) {
		this.phoneNumberVerificationStaus = phoneNumberVerificationStaus;
	}

	public String getProfileImage() {
		return this.profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public List<BookingDetail> getBookingDetails() {
		return this.bookingDetails;
	}

	public void setBookingDetails(List<BookingDetail> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	public BookingDetail addBookingDetail(BookingDetail bookingDetail) {
		getBookingDetails().add(bookingDetail);
		bookingDetail.setUserProfile(this);

		return bookingDetail;
	}

	public BookingDetail removeBookingDetail(BookingDetail bookingDetail) {
		getBookingDetails().remove(bookingDetail);
		bookingDetail.setUserProfile(null);

		return bookingDetail;
	}

	public List<UsedCoupon> getUsedCoupons() {
		return this.usedCoupons;
	}

	public void setUsedCoupons(List<UsedCoupon> usedCoupons) {
		this.usedCoupons = usedCoupons;
	}

	public UsedCoupon addUsedCoupon(UsedCoupon usedCoupon) {
		getUsedCoupons().add(usedCoupon);
		usedCoupon.setUserProfile(this);

		return usedCoupon;
	}

	public UsedCoupon removeUsedCoupon(UsedCoupon usedCoupon) {
		getUsedCoupons().remove(usedCoupon);
		usedCoupon.setUserProfile(null);

		return usedCoupon;
	}

	public List<UserGroupMapping> getUserGroupMappings() {
		return this.userGroupMappings;
	}

	public void setUserGroupMappings(List<UserGroupMapping> userGroupMappings) {
		this.userGroupMappings = userGroupMappings;
	}

	public UserGroupMapping addUserGroupMapping(UserGroupMapping userGroupMapping) {
		getUserGroupMappings().add(userGroupMapping);
		userGroupMapping.setUserProfile(this);

		return userGroupMapping;
	}

	public UserGroupMapping removeUserGroupMapping(UserGroupMapping userGroupMapping) {
		getUserGroupMappings().remove(userGroupMapping);
		userGroupMapping.setUserProfile(null);

		return userGroupMapping;
	}

	public List<UserSavedAddress> getUserSavedAddresses() {
		return this.userSavedAddresses;
	}

	public void setUserSavedAddresses(List<UserSavedAddress> userSavedAddresses) {
		this.userSavedAddresses = userSavedAddresses;
	}

	public UserSavedAddress addUserSavedAddress(UserSavedAddress userSavedAddress) {
		getUserSavedAddresses().add(userSavedAddress);
		userSavedAddress.setUserProfile(this);

		return userSavedAddress;
	}

	public UserSavedAddress removeUserSavedAddress(UserSavedAddress userSavedAddress) {
		getUserSavedAddresses().remove(userSavedAddress);
		userSavedAddress.setUserProfile(null);

		return userSavedAddress;
	}

}