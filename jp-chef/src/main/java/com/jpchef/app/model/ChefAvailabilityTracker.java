package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the chef_availability_tracker database table.
 * 
 */
@Entity
@Table(name="chef_availability_tracker")
@NamedQuery(name="ChefAvailabilityTracker.findAll", query="SELECT c FROM ChefAvailabilityTracker c")
public class ChefAvailabilityTracker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="record_id")
	private Long recordId;

	@Column(name="end_time")
	private Timestamp endTime;

	@Column(name="start_time")
	private Timestamp startTime;

	//bi-directional many-to-one association to ChefDetail
	@ManyToOne
	@JoinColumn(name="chef_id")
	private ChefDetail chefDetail;

	public ChefAvailabilityTracker() {
	}

	public Long getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public ChefDetail getChefDetail() {
		return this.chefDetail;
	}

	public void setChefDetail(ChefDetail chefDetail) {
		this.chefDetail = chefDetail;
	}

}