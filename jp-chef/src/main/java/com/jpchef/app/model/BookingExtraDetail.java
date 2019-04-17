package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the booking_extra_details database table.
 * 
 */
@Entity
@Table(name="booking_extra_details")
@NamedQuery(name="BookingExtraDetail.findAll", query="SELECT b FROM BookingExtraDetail b")
public class BookingExtraDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="booking_extra_detail_id")
	private Long bookingExtraDetailId;

	//bi-directional many-to-one association to AllDishe
	@ManyToOne
	@JoinColumn(name="dish_id")
	private AllDishe allDishe;

	//bi-directional many-to-one association to BookingDetail
	@ManyToOne
	@JoinColumn(name="booking_id")
	private BookingDetail bookingDetail;

	public BookingExtraDetail() {
	}

	public Long getBookingExtraDetailId() {
		return this.bookingExtraDetailId;
	}

	public void setBookingExtraDetailId(Long bookingExtraDetailId) {
		this.bookingExtraDetailId = bookingExtraDetailId;
	}

	public AllDishe getAllDishe() {
		return this.allDishe;
	}

	public void setAllDishe(AllDishe allDishe) {
		this.allDishe = allDishe;
	}

	public BookingDetail getBookingDetail() {
		return this.bookingDetail;
	}

	public void setBookingDetail(BookingDetail bookingDetail) {
		this.bookingDetail = bookingDetail;
	}

}