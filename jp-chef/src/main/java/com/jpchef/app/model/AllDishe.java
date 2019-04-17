package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the all_dishes database table.
 * 
 */
@Entity
@Table(name="all_dishes")
@NamedQuery(name="AllDishe.findAll", query="SELECT a FROM AllDishe a")
public class AllDishe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dish_id")
	private Long dishId;

	private String description;

	@Column(name="dish_category")
	private Integer dishCategory;

	@Column(name="dish_image")
	private String dishImage;

	@Column(name="dish_name")
	private String dishName;

	@Column(name="dish_type")
	private Integer dishType;

	@Column(name="dish_video")
	private String dishVideo;

	//bi-directional many-to-one association to AllDishRating
	@OneToMany(mappedBy="allDishe")
	private List<AllDishRating> allDishRatings;

	//bi-directional many-to-one association to AllCuisine
	@ManyToOne
	@JoinColumn(name="cuisine_id")
	private AllCuisine allCuisine;

	//bi-directional many-to-one association to BookingExtraDetail
	@OneToMany(mappedBy="allDishe")
	private List<BookingExtraDetail> bookingExtraDetails;

	//bi-directional many-to-one association to ChefDishMapping
	@OneToMany(mappedBy="allDishe")
	private List<ChefDishMapping> chefDishMappings;

	//bi-directional many-to-one association to DishIngredientMapping
	@OneToMany(mappedBy="allDishe")
	private List<DishIngredientMapping> dishIngredientMappings;

	public AllDishe() {
	}

	public Long getDishId() {
		return this.dishId;
	}

	public void setDishId(Long dishId) {
		this.dishId = dishId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDishCategory() {
		return this.dishCategory;
	}

	public void setDishCategory(Integer dishCategory) {
		this.dishCategory = dishCategory;
	}

	public String getDishImage() {
		return this.dishImage;
	}

	public void setDishImage(String dishImage) {
		this.dishImage = dishImage;
	}

	public String getDishName() {
		return this.dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public Integer getDishType() {
		return this.dishType;
	}

	public void setDishType(Integer dishType) {
		this.dishType = dishType;
	}

	public String getDishVideo() {
		return this.dishVideo;
	}

	public void setDishVideo(String dishVideo) {
		this.dishVideo = dishVideo;
	}

	public List<AllDishRating> getAllDishRatings() {
		return this.allDishRatings;
	}

	public void setAllDishRatings(List<AllDishRating> allDishRatings) {
		this.allDishRatings = allDishRatings;
	}

	public AllDishRating addAllDishRating(AllDishRating allDishRating) {
		getAllDishRatings().add(allDishRating);
		allDishRating.setAllDishe(this);

		return allDishRating;
	}

	public AllDishRating removeAllDishRating(AllDishRating allDishRating) {
		getAllDishRatings().remove(allDishRating);
		allDishRating.setAllDishe(null);

		return allDishRating;
	}

	public AllCuisine getAllCuisine() {
		return this.allCuisine;
	}

	public void setAllCuisine(AllCuisine allCuisine) {
		this.allCuisine = allCuisine;
	}

	public List<BookingExtraDetail> getBookingExtraDetails() {
		return this.bookingExtraDetails;
	}

	public void setBookingExtraDetails(List<BookingExtraDetail> bookingExtraDetails) {
		this.bookingExtraDetails = bookingExtraDetails;
	}

	public BookingExtraDetail addBookingExtraDetail(BookingExtraDetail bookingExtraDetail) {
		getBookingExtraDetails().add(bookingExtraDetail);
		bookingExtraDetail.setAllDishe(this);

		return bookingExtraDetail;
	}

	public BookingExtraDetail removeBookingExtraDetail(BookingExtraDetail bookingExtraDetail) {
		getBookingExtraDetails().remove(bookingExtraDetail);
		bookingExtraDetail.setAllDishe(null);

		return bookingExtraDetail;
	}

	public List<ChefDishMapping> getChefDishMappings() {
		return this.chefDishMappings;
	}

	public void setChefDishMappings(List<ChefDishMapping> chefDishMappings) {
		this.chefDishMappings = chefDishMappings;
	}

	public ChefDishMapping addChefDishMapping(ChefDishMapping chefDishMapping) {
		getChefDishMappings().add(chefDishMapping);
		chefDishMapping.setAllDishe(this);

		return chefDishMapping;
	}

	public ChefDishMapping removeChefDishMapping(ChefDishMapping chefDishMapping) {
		getChefDishMappings().remove(chefDishMapping);
		chefDishMapping.setAllDishe(null);

		return chefDishMapping;
	}

	public List<DishIngredientMapping> getDishIngredientMappings() {
		return this.dishIngredientMappings;
	}

	public void setDishIngredientMappings(List<DishIngredientMapping> dishIngredientMappings) {
		this.dishIngredientMappings = dishIngredientMappings;
	}

	public DishIngredientMapping addDishIngredientMapping(DishIngredientMapping dishIngredientMapping) {
		getDishIngredientMappings().add(dishIngredientMapping);
		dishIngredientMapping.setAllDishe(this);

		return dishIngredientMapping;
	}

	public DishIngredientMapping removeDishIngredientMapping(DishIngredientMapping dishIngredientMapping) {
		getDishIngredientMappings().remove(dishIngredientMapping);
		dishIngredientMapping.setAllDishe(null);

		return dishIngredientMapping;
	}

}