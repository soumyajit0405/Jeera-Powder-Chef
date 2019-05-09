package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the admin_users database table.
 * 
 */
@Entity
@Table(name="admin_users")
@NamedQuery(name="AdminUser.findAll", query="SELECT a FROM AdminUser a")
public class AdminUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="admin_id")
	private Long adminId;

	private String password;

	private String username;

	public AdminUser() {
	}

	public Long getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}