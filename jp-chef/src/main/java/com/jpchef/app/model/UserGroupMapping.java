package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_group_mappings database table.
 * 
 */
@Entity
@Table(name="user_group_mappings")
@NamedQuery(name="UserGroupMapping.findAll", query="SELECT u FROM UserGroupMapping u")
public class UserGroupMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_group_mapping_id")
	private Long userGroupMappingId;

	@Column(name="soft_delete_flag")
	private Boolean softDeleteFlag;

	//bi-directional many-to-one association to UserGroup
	@ManyToOne
	@JoinColumn(name="user_group_id")
	private UserGroup userGroup;

	//bi-directional many-to-one association to UserProfile
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserProfile userProfile;

	public UserGroupMapping() {
	}

	public Long getUserGroupMappingId() {
		return this.userGroupMappingId;
	}

	public void setUserGroupMappingId(Long userGroupMappingId) {
		this.userGroupMappingId = userGroupMappingId;
	}

	public Boolean getSoftDeleteFlag() {
		return this.softDeleteFlag;
	}

	public void setSoftDeleteFlag(Boolean softDeleteFlag) {
		this.softDeleteFlag = softDeleteFlag;
	}

	public UserGroup getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

}