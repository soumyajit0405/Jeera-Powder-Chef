package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the all_chef_ratings database table.
 * 
 */
@Entity
@Table(name="all_chef_ratings")
@NamedQuery(name="AllChefRating.findAll", query="SELECT a FROM AllChefRating a")
public class AllChefRating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="rating_id")
	private Long ratingId;

	@Column(name="long_comment")
	private String longComment;

	@Column(name="rating_value")
	private BigDecimal ratingValue;

	@Column(name="short_comment")
	private String shortComment;

	//bi-directional many-to-one association to BookingDetail
	@ManyToOne
	@JoinColumn(name="bookig_id")
	private BookingDetail bookingDetail;

	//bi-directional many-to-one association to ChefDetail
	@ManyToOne
	@JoinColumn(name="chef_id")
	private ChefDetail chefDetail;

	public AllChefRating() {
	}

	public Long getRatingId() {
		return this.ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public String getLongComment() {
		return this.longComment;
	}

	public void setLongComment(String longComment) {
		this.longComment = longComment;
	}

	public BigDecimal getRatingValue() {
		return this.ratingValue;
	}

	public void setRatingValue(BigDecimal ratingValue) {
		this.ratingValue = ratingValue;
	}

	public String getShortComment() {
		return this.shortComment;
	}

	public void setShortComment(String shortComment) {
		this.shortComment = shortComment;
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