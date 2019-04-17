package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the chef_earnings_payouts_total database table.
 * 
 */
@Entity
@Table(name="chef_earnings_payouts_total")
@NamedQuery(name="ChefEarningsPayoutsTotal.findAll", query="SELECT c FROM ChefEarningsPayoutsTotal c")
public class ChefEarningsPayoutsTotal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="chef_earnings_payout_id")
	private Long chefEarningsPayoutId;

	@Column(name="chef_id")
	private Long chefId;

	@Column(name="last_payout")
	private BigDecimal lastPayout;

	@Temporal(TemporalType.DATE)
	@Column(name="last_payout_date")
	private Date lastPayoutDate;

	@Column(name="last_payout_ref_key")
	private Long lastPayoutRefKey;

	@Column(name="total_amount_since_last_payout")
	private BigDecimal totalAmountSinceLastPayout;

	@Column(name="total_payouts")
	private BigDecimal totalPayouts;

	public ChefEarningsPayoutsTotal() {
	}

	public Long getChefEarningsPayoutId() {
		return this.chefEarningsPayoutId;
	}

	public void setChefEarningsPayoutId(Long chefEarningsPayoutId) {
		this.chefEarningsPayoutId = chefEarningsPayoutId;
	}

	public Long getChefId() {
		return this.chefId;
	}

	public void setChefId(Long chefId) {
		this.chefId = chefId;
	}

	public BigDecimal getLastPayout() {
		return this.lastPayout;
	}

	public void setLastPayout(BigDecimal lastPayout) {
		this.lastPayout = lastPayout;
	}

	public Date getLastPayoutDate() {
		return this.lastPayoutDate;
	}

	public void setLastPayoutDate(Date lastPayoutDate) {
		this.lastPayoutDate = lastPayoutDate;
	}

	public Long getLastPayoutRefKey() {
		return this.lastPayoutRefKey;
	}

	public void setLastPayoutRefKey(Long lastPayoutRefKey) {
		this.lastPayoutRefKey = lastPayoutRefKey;
	}

	public BigDecimal getTotalAmountSinceLastPayout() {
		return this.totalAmountSinceLastPayout;
	}

	public void setTotalAmountSinceLastPayout(BigDecimal totalAmountSinceLastPayout) {
		this.totalAmountSinceLastPayout = totalAmountSinceLastPayout;
	}

	public BigDecimal getTotalPayouts() {
		return this.totalPayouts;
	}

	public void setTotalPayouts(BigDecimal totalPayouts) {
		this.totalPayouts = totalPayouts;
	}

}