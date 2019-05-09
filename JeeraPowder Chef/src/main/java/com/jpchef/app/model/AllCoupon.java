package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the all_coupons database table.
 * 
 */
@Entity
@Table(name="all_coupons")
@NamedQuery(name="AllCoupon.findAll", query="SELECT a FROM AllCoupon a")
public class AllCoupon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="coupon_id")
	private Long couponId;

	@Column(name="can_be_clubbed_flag")
	private Boolean canBeClubbedFlag;

	@Column(name="coupon_string")
	private String couponString;

	@Column(name="coupon_value")
	private BigDecimal couponValue;

	@Column(name="discount_type")
	private Integer discountType;

	@Column(name="end_time")
	private Timestamp endTime;

	@Column(name="max_discount")
	private BigDecimal maxDiscount;

	@Column(name="min_order_value")
	private BigDecimal minOrderValue;

	@Column(name="remaining_count")
	private BigDecimal remainingCount;

	@Column(name="start_time")
	private Timestamp startTime;

	private Integer status;

	@Column(name="total_count")
	private BigDecimal totalCount;

	//bi-directional many-to-one association to UserGroup
	@ManyToOne
	@JoinColumn(name="user_group_id")
	private UserGroup userGroup;

	public AllCoupon() {
	}

	public Long getCouponId() {
		return this.couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public Boolean getCanBeClubbedFlag() {
		return this.canBeClubbedFlag;
	}

	public void setCanBeClubbedFlag(Boolean canBeClubbedFlag) {
		this.canBeClubbedFlag = canBeClubbedFlag;
	}

	public String getCouponString() {
		return this.couponString;
	}

	public void setCouponString(String couponString) {
		this.couponString = couponString;
	}

	public BigDecimal getCouponValue() {
		return this.couponValue;
	}

	public void setCouponValue(BigDecimal couponValue) {
		this.couponValue = couponValue;
	}

	public Integer getDiscountType() {
		return this.discountType;
	}

	public void setDiscountType(Integer discountType) {
		this.discountType = discountType;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public BigDecimal getMaxDiscount() {
		return this.maxDiscount;
	}

	public void setMaxDiscount(BigDecimal maxDiscount) {
		this.maxDiscount = maxDiscount;
	}

	public BigDecimal getMinOrderValue() {
		return this.minOrderValue;
	}

	public void setMinOrderValue(BigDecimal minOrderValue) {
		this.minOrderValue = minOrderValue;
	}

	public BigDecimal getRemainingCount() {
		return this.remainingCount;
	}

	public void setRemainingCount(BigDecimal remainingCount) {
		this.remainingCount = remainingCount;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigDecimal getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(BigDecimal totalCount) {
		this.totalCount = totalCount;
	}

	public UserGroup getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

}