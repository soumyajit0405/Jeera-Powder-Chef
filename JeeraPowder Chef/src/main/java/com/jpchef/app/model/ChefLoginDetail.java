package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the chef_login_details database table.
 * 
 */
@Entity
@Table(name="chef_login_details")
@NamedQuery(name="ChefLoginDetail.findAll", query="SELECT c FROM ChefLoginDetail c")
public class ChefLoginDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="auth_ref_key")
	private Long authRefKey;

	@Column(name="chef_account_status")
	private Integer chefAccountStatus;

	@Column(name="chef_id")
	private Long chefId;

	@Id
	@Column(name="chef_login_details_id")
	private Long chefLoginDetailsId;

	@Column(name="chef_password")
	private String chefPassword;

	@Column(name="chef_user_id")
	private Long chefUserId;

	@Temporal(TemporalType.DATE)
	@Column(name="last_login_time")
	private Date lastLoginTime;

	@Column(name="login_type")
	private Integer loginType;

	public ChefLoginDetail() {
	}

	public Long getAuthRefKey() {
		return this.authRefKey;
	}

	public void setAuthRefKey(Long authRefKey) {
		this.authRefKey = authRefKey;
	}

	public Integer getChefAccountStatus() {
		return this.chefAccountStatus;
	}

	public void setChefAccountStatus(Integer chefAccountStatus) {
		this.chefAccountStatus = chefAccountStatus;
	}

	public Long getChefId() {
		return this.chefId;
	}

	public void setChefId(Long chefId) {
		this.chefId = chefId;
	}

	public Long getChefLoginDetailsId() {
		return this.chefLoginDetailsId;
	}

	public void setChefLoginDetailsId(Long chefLoginDetailsId) {
		this.chefLoginDetailsId = chefLoginDetailsId;
	}

	public String getChefPassword() {
		return this.chefPassword;
	}

	public void setChefPassword(String chefPassword) {
		this.chefPassword = chefPassword;
	}

	public Long getChefUserId() {
		return this.chefUserId;
	}

	public void setChefUserId(Long chefUserId) {
		this.chefUserId = chefUserId;
	}

	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Integer getLoginType() {
		return this.loginType;
	}

	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}

}