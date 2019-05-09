package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the general_chef_ratings database table.
 * 
 */
@Entity
@Table(name="general_chef_ratings")
@NamedQuery(name="GeneralChefRating.findAll", query="SELECT g FROM GeneralChefRating g")
public class GeneralChefRating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="general_ratings_id")
	private Long generalRatingsId;

	@Column(name="average_rating_value")
	private String averageRatingValue;

	@Column(name="number_of_ratings")
	private Integer numberOfRatings;

	//bi-directional many-to-one association to ChefDetail
	@ManyToOne
	@JoinColumn(name="chef_id")
	private ChefDetail chefDetail;

	public GeneralChefRating() {
	}

	public Long getGeneralRatingsId() {
		return this.generalRatingsId;
	}

	public void setGeneralRatingsId(Long generalRatingsId) {
		this.generalRatingsId = generalRatingsId;
	}

	public String getAverageRatingValue() {
		return this.averageRatingValue;
	}

	public void setAverageRatingValue(String averageRatingValue) {
		this.averageRatingValue = averageRatingValue;
	}

	public Integer getNumberOfRatings() {
		return this.numberOfRatings;
	}

	public void setNumberOfRatings(Integer numberOfRatings) {
		this.numberOfRatings = numberOfRatings;
	}

	public ChefDetail getChefDetail() {
		return this.chefDetail;
	}

	public void setChefDetail(ChefDetail chefDetail) {
		this.chefDetail = chefDetail;
	}

}