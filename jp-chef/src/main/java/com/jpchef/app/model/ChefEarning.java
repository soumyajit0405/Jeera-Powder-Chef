package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the chef_earnings database table.
 * 
 */
@Entity
@Table(name="chef_earnings")
@NamedQuery(name="ChefEarning.findAll", query="SELECT c FROM ChefEarning c")
public class ChefEarning implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="chef_earnings_id")
	private Long chefEarningsId;

	@Column(name="chef_earnings")
	private BigDecimal chefEarnings;

	@Column(name="offset_reason")
	private Integer offsetReason;

	@Column(name="offset_value")
	private BigDecimal offsetValue;

	@Column(name="tax_component")
	private BigDecimal taxComponent;

	//bi-directional many-to-one association to BookingDetail
	@ManyToOne
	@JoinColumn(name="booking_id")
	private BookingDetail bookingDetail;

	//bi-directional many-to-one association to ChefDetail
	@ManyToOne
	@JoinColumn(name="chef_id")
	private ChefDetail chefDetail;

	public ChefEarning() {
	}

	public Long getChefEarningsId() {
		return this.chefEarningsId;
	}

	public void setChefEarningsId(Long chefEarningsId) {
		this.chefEarningsId = chefEarningsId;
	}

	public BigDecimal getChefEarnings() {
		return this.chefEarnings;
	}

	public void setChefEarnings(BigDecimal chefEarnings) {
		this.chefEarnings = chefEarnings;
	}

	public Integer getOffsetReason() {
		return this.offsetReason;
	}

	public void setOffsetReason(Integer offsetReason) {
		this.offsetReason = offsetReason;
	}

	public BigDecimal getOffsetValue() {
		return this.offsetValue;
	}

	public void setOffsetValue(BigDecimal offsetValue) {
		this.offsetValue = offsetValue;
	}

	public BigDecimal getTaxComponent() {
		return this.taxComponent;
	}

	public void setTaxComponent(BigDecimal taxComponent) {
		this.taxComponent = taxComponent;
	}

	public BookingDetail getBookingDetail() {
		return this.bookingDetail;
	}

	public void setBookingDetail(BookingDetail bookingDetail) {
		this.bookingDetail = bookingDetail;
	}

	public ChefDetail getChefDetail() {
		return this.chefDetail;
	}

	public void setChefDetail(ChefDetail chefDetail) {
		this.chefDetail = chefDetail;
	}

}