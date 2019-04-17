package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the payment_breakdown database table.
 * 
 */
@Entity
@Table(name="payment_breakdown")
@NamedQuery(name="PaymentBreakdown.findAll", query="SELECT p FROM PaymentBreakdown p")
public class PaymentBreakdown implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="payment_breakdown_id")
	private Long paymentBreakdownId;

	private double bonus;

	@Column(name="chef_commision")
	private double chefCommision;

	@Column(name="chef_tip")
	private double chefTip;

	@Column(name="jp_earnings")
	private double jpEarnings;

	@Column(name="other_one")
	private double otherOne;

	@Column(name="other_three")
	private double otherThree;

	@Column(name="other_two")
	private double otherTwo;

	@Column(name="tax_component_four")
	private double taxComponentFour;

	@Column(name="tax_component_one")
	private double taxComponentOne;

	@Column(name="tax_component_three")
	private double taxComponentThree;

	@Column(name="tax_component_two")
	private double taxComponentTwo;

	@Column(name="third_party_commision")
	private double thirdPartyCommision;

	//bi-directional many-to-one association to AllPayment
	@ManyToOne
	@JoinColumn(name="payment_id")
	private AllPayment allPayment;

	public PaymentBreakdown() {
	}

	public Long getPaymentBreakdownId() {
		return this.paymentBreakdownId;
	}

	public void setPaymentBreakdownId(Long paymentBreakdownId) {
		this.paymentBreakdownId = paymentBreakdownId;
	}

	public double getBonus() {
		return this.bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getChefCommision() {
		return this.chefCommision;
	}

	public void setChefCommision(double chefCommision) {
		this.chefCommision = chefCommision;
	}

	public double getChefTip() {
		return this.chefTip;
	}

	public void setChefTip(double chefTip) {
		this.chefTip = chefTip;
	}

	public double getJpEarnings() {
		return this.jpEarnings;
	}

	public void setJpEarnings(double jpEarnings) {
		this.jpEarnings = jpEarnings;
	}

	public double getOtherOne() {
		return this.otherOne;
	}

	public void setOtherOne(double otherOne) {
		this.otherOne = otherOne;
	}

	public double getOtherThree() {
		return this.otherThree;
	}

	public void setOtherThree(double otherThree) {
		this.otherThree = otherThree;
	}

	public double getOtherTwo() {
		return this.otherTwo;
	}

	public void setOtherTwo(double otherTwo) {
		this.otherTwo = otherTwo;
	}

	public double getTaxComponentFour() {
		return this.taxComponentFour;
	}

	public void setTaxComponentFour(double taxComponentFour) {
		this.taxComponentFour = taxComponentFour;
	}

	public double getTaxComponentOne() {
		return this.taxComponentOne;
	}

	public void setTaxComponentOne(double taxComponentOne) {
		this.taxComponentOne = taxComponentOne;
	}

	public double getTaxComponentThree() {
		return this.taxComponentThree;
	}

	public void setTaxComponentThree(double taxComponentThree) {
		this.taxComponentThree = taxComponentThree;
	}

	public double getTaxComponentTwo() {
		return this.taxComponentTwo;
	}

	public void setTaxComponentTwo(double taxComponentTwo) {
		this.taxComponentTwo = taxComponentTwo;
	}

	public double getThirdPartyCommision() {
		return this.thirdPartyCommision;
	}

	public void setThirdPartyCommision(double thirdPartyCommision) {
		this.thirdPartyCommision = thirdPartyCommision;
	}

	public AllPayment getAllPayment() {
		return this.allPayment;
	}

	public void setAllPayment(AllPayment allPayment) {
		this.allPayment = allPayment;
	}

}