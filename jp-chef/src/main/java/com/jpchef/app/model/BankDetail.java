package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bank_details database table.
 * 
 */
@Entity
@Table(name="bank_details")
@NamedQuery(name="BankDetail.findAll", query="SELECT b FROM BankDetail b")
public class BankDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bank_record_key")
	private Long bankRecordKey;

	@Column(name="account_number")
	private String accountNumber;

	@Column(name="bank_address")
	private String bankAddress;

	@Column(name="ifsc_code")
	private String ifscCode;

	//bi-directional many-to-one association to ChefDetail
	@ManyToOne
	@JoinColumn(name="chef_id")
	private ChefDetail chefDetail;

	public BankDetail() {
	}

	public Long getBankRecordKey() {
		return this.bankRecordKey;
	}

	public void setBankRecordKey(Long bankRecordKey) {
		this.bankRecordKey = bankRecordKey;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankAddress() {
		return this.bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getIfscCode() {
		return this.ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public ChefDetail getChefDetail() {
		return this.chefDetail;
	}

	public void setChefDetail(ChefDetail chefDetail) {
		this.chefDetail = chefDetail;
	}

}