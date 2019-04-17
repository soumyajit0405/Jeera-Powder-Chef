package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the all_dish_ratings database table.
 * 
 */
@Entity
@Table(name="all_dish_ratings")
@NamedQuery(name="AllDishRating.findAll", query="SELECT a FROM AllDishRating a")
public class AllDishRating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dish_rating")
	private Long dishRating;

	@Column(name="long_comment")
	private String longComment;

	@Column(name="rating_value")
	private BigDecimal ratingValue;

	@Column(name="short_comment")
	private String shortComment;

	//bi-directional many-to-one association to AllDishe
	@ManyToOne
	@JoinColumn(name="dish_id")
	private AllDishe allDishe;

	//bi-directional many-to-one association to UserGroup
	@ManyToOne
	@JoinColumn(name="rating_id")
	private UserGroup userGroup;

	public AllDishRating() {
	}

	public Long getDishRating() {
		return this.dishRating;
	}

	public void setDishRating(Long dishRating) {
		this.dishRating = dishRating;
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

	public AllDishe getAllDishe() {
		return this.allDishe;
	}

	public void setAllDishe(AllDishe allDishe) {
		this.allDishe = allDishe;
	}

	public UserGroup getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

}