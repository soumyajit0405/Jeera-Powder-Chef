package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the chef_payouts database table.
 * 
 */
@Entity
@Table(name="chef_payouts")
@NamedQuery(name="ChefPayout.findAll", query="SELECT c FROM ChefPayout c")
public class ChefPayout implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="chef_payout_id")
	private Long chefPayoutId;

	@Column(name="chef_payout_amount")
	private BigDecimal chefPayoutAmount;

	private String comments;

	@Column(name="extra_info1")
	private String extraInfo1;

	@Column(name="extra_info2")
	private String extraInfo2;

	@Column(name="extra_info3")
	private String extraInfo3;

	@Column(name="refernce_id")
	private String refernceId;

	@Column(name="transaction_timestamp")
	private Timestamp transactionTimestamp;

	@Column(name="transfer_mode")
	private Integer transferMode;

	//bi-directional many-to-one association to ChefDetail
	@ManyToOne
	@JoinColumn(name="chef_id")
	private ChefDetail chefDetail;

	public ChefPayout() {
	}

	public Long getChefPayoutId() {
		return this.chefPayoutId;
	}

	public void setChefPayoutId(Long chefPayoutId) {
		this.chefPayoutId = chefPayoutId;
	}

	public BigDecimal getChefPayoutAmount() {
		return this.chefPayoutAmount;
	}

	public void setChefPayoutAmount(BigDecimal chefPayoutAmount) {
		this.chefPayoutAmount = chefPayoutAmount;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getExtraInfo1() {
		return this.extraInfo1;
	}

	public void setExtraInfo1(String extraInfo1) {
		this.extraInfo1 = extraInfo1;
	}

	public String getExtraInfo2() {
		return this.extraInfo2;
	}

	public void setExtraInfo2(String extraInfo2) {
		this.extraInfo2 = extraInfo2;
	}

	public String getExtraInfo3() {
		return this.extraInfo3;
	}

	public void setExtraInfo3(String extraInfo3) {
		this.extraInfo3 = extraInfo3;
	}

	public String getRefernceId() {
		return this.refernceId;
	}

	public void setRefernceId(String refernceId) {
		this.refernceId = refernceId;
	}

	public Timestamp getTransactionTimestamp() {
		return this.transactionTimestamp;
	}

	public void setTransactionTimestamp(Timestamp transactionTimestamp) {
		this.transactionTimestamp = transactionTimestamp;
	}

	public Integer getTransferMode() {
		return this.transferMode;
	}

	public void setTransferMode(Integer transferMode) {
		this.transferMode = transferMode;
	}

	public ChefDetail getChefDetail() {
		return this.chefDetail;
	}

	public void setChefDetail(ChefDetail chefDetail) {
		this.chefDetail = chefDetail;
	}

}