package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the used_coupons database table.
 * 
 */
@Entity
@Table(name="used_coupons")
@NamedQuery(name="UsedCoupon.findAll", query="SELECT u FROM UsedCoupon u")
public class UsedCoupon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="used_coupon_id")
	private Long usedCouponId;

	@Column(name="discount_amount")
	private BigDecimal discountAmount;

	@Column(name="used_datetime")
	private Timestamp usedDatetime;

	//bi-directional many-to-one association to BookingDetail
	@ManyToOne
	@JoinColumn(name="booking_id")
	private BookingDetail bookingDetail;

	//bi-directional many-to-one association to UserProfile
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserProfile userProfile;

	public UsedCoupon() {
	}

	public Long getUsedCouponId() {
		return this.usedCouponId;
	}

	public void setUsedCouponId(Long usedCouponId) {
		this.usedCouponId = usedCouponId;
	}

	public BigDecimal getDiscountAmount() {
		return this.discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Timestamp getUsedDatetime() {
		return this.usedDatetime;
	}

	public void setUsedDatetime(Timestamp usedDatetime) {
		this.usedDatetime = usedDatetime;
	}

	public BookingDetail getBookingDetail() {
		return this.bookingDetail;
	}

	public void setBookingDetail(BookingDetail bookingDetail) {
		this.bookingDetail = bookingDetail;
	}

	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

}