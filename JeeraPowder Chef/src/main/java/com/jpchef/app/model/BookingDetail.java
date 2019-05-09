package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Type;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpchef.app.util.PGPointType;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the booking_details database table.
 * 
 */
@Entity
@Table(name="booking_details")
@NamedQuery(name="BookingDetail.findAll", query="SELECT b FROM BookingDetail b")
public class BookingDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="booking_id")
	private Long bookingId;

	@Column(name="extra_main_course_count")
	private BigDecimal extraMainCourseCount;

	@Column(name="base_cost")
	private BigDecimal baseCost;

	@JsonIgnore
	@Column(name="booking_location")
 //   @Type(type = "org.hibernate.spatial.GeometryType")
	private PGPointType bookingLocation;

	@Column(name="booking_status")
	private Integer bookingStatus;

	private String comments;

	@Column(name="discount_ref_key")
	private Long discountRefKey;

	private BigDecimal discounts;

	@Column(name="end_time")
	private Timestamp endTime;

	@Column(name="extra_accompaniment_cost")
	private BigDecimal extraAccompanimentCost;

	@Column(name="extra_accompaniment_count")
	private BigDecimal extraAccompanimentCount;

	@Column(name="extra_dessert_cost")
	private BigDecimal extraDessertCost;

	@Column(name="extra_dessert_count")
	private BigDecimal extraDessertCount;

	@Column(name="extra_main_course_cost")
	private BigDecimal extraMainCourseCost;

	@Column(name="extra_person_cost")
	private BigDecimal extraPersonCost;

	@Column(name="extra_person_count")
	private BigDecimal extraPersonCount;

	@Column(name="extra_starter_cost")
	private BigDecimal extraStarterCost;

	@Column(name="extra_starter_count")
	private BigDecimal extraStarterCount;

	@Column(name="offset_costs")
	private BigDecimal offsetCosts;

	@Column(name="start_time")
	private Timestamp startTime;

	//bi-directional many-to-one association to AllChefRating
	@OneToMany(mappedBy="bookingDetail")
	private List<AllChefRating> allChefRatings;

	//bi-directional many-to-one association to AllPayment
	@OneToMany(mappedBy="bookingDetail")
	private List<AllPayment> allPayments;

	//bi-directional many-to-one association to ChefDetail
	@ManyToOne
	@JoinColumn(name="chef_id")
	private ChefDetail chefDetail;

	//bi-directional many-to-one association to UserProfile
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserProfile userProfile;

	//bi-directional many-to-one association to BookingExtraDetail
	@OneToMany(mappedBy="bookingDetail")
	private List<BookingExtraDetail> bookingExtraDetails;

	//bi-directional many-to-one association to ChefEarning
	@OneToMany(mappedBy="bookingDetail")
	private List<ChefEarning> chefEarnings;

	//bi-directional many-to-one association to UsedCoupon
	@OneToMany(mappedBy="bookingDetail")
	private List<UsedCoupon> usedCoupons;

	public BookingDetail() {
	}

	public Long getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public BigDecimal getExtraMainCourseCount() {
		return this.extraMainCourseCount;
	}

	public void setExtraMainCourseCount(BigDecimal extraMainCourseCount) {
		this.extraMainCourseCount = extraMainCourseCount;
	}

	public BigDecimal getBaseCost() {
		return this.baseCost;
	}

	public void setBaseCost(BigDecimal baseCost) {
		this.baseCost = baseCost;
	}

	public PGPointType getBookingLocation() {
		return this.bookingLocation;
	}

	public void setBookingLocation(PGPointType bookingLocation) {
		this.bookingLocation = bookingLocation;
	}

	public Integer getBookingStatus() {
		return this.bookingStatus;
	}

	public void setBookingStatus(Integer bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Long getDiscountRefKey() {
		return this.discountRefKey;
	}

	public void setDiscountRefKey(Long discountRefKey) {
		this.discountRefKey = discountRefKey;
	}

	public BigDecimal getDiscounts() {
		return this.discounts;
	}

	public void setDiscounts(BigDecimal discounts) {
		this.discounts = discounts;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public BigDecimal getExtraAccompanimentCost() {
		return this.extraAccompanimentCost;
	}

	public void setExtraAccompanimentCost(BigDecimal extraAccompanimentCost) {
		this.extraAccompanimentCost = extraAccompanimentCost;
	}

	public BigDecimal getExtraAccompanimentCount() {
		return this.extraAccompanimentCount;
	}

	public void setExtraAccompanimentCount(BigDecimal extraAccompanimentCount) {
		this.extraAccompanimentCount = extraAccompanimentCount;
	}

	public BigDecimal getExtraDessertCost() {
		return this.extraDessertCost;
	}

	public void setExtraDessertCost(BigDecimal extraDessertCost) {
		this.extraDessertCost = extraDessertCost;
	}

	public BigDecimal getExtraDessertCount() {
		return this.extraDessertCount;
	}

	public void setExtraDessertCount(BigDecimal extraDessertCount) {
		this.extraDessertCount = extraDessertCount;
	}

	public BigDecimal getExtraMainCourseCost() {
		return this.extraMainCourseCost;
	}

	public void setExtraMainCourseCost(BigDecimal extraMainCourseCost) {
		this.extraMainCourseCost = extraMainCourseCost;
	}

	public BigDecimal getExtraPersonCost() {
		return this.extraPersonCost;
	}

	public void setExtraPersonCost(BigDecimal extraPersonCost) {
		this.extraPersonCost = extraPersonCost;
	}

	public BigDecimal getExtraPersonCount() {
		return this.extraPersonCount;
	}

	public void setExtraPersonCount(BigDecimal extraPersonCount) {
		this.extraPersonCount = extraPersonCount;
	}

	public BigDecimal getExtraStarterCost() {
		return this.extraStarterCost;
	}

	public void setExtraStarterCost(BigDecimal extraStarterCost) {
		this.extraStarterCost = extraStarterCost;
	}

	public BigDecimal getExtraStarterCount() {
		return this.extraStarterCount;
	}

	public void setExtraStarterCount(BigDecimal extraStarterCount) {
		this.extraStarterCount = extraStarterCount;
	}

	public BigDecimal getOffsetCosts() {
		return this.offsetCosts;
	}

	public void setOffsetCosts(BigDecimal offsetCosts) {
		this.offsetCosts = offsetCosts;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public List<AllChefRating> getAllChefRatings() {
		return this.allChefRatings;
	}

	public void setAllChefRatings(List<AllChefRating> allChefRatings) {
		this.allChefRatings = allChefRatings;
	}

	public AllChefRating addAllChefRating(AllChefRating allChefRating) {
		getAllChefRatings().add(allChefRating);
		allChefRating.setBookingDetail(this);

		return allChefRating;
	}

	public AllChefRating removeAllChefRating(AllChefRating allChefRating) {
		getAllChefRatings().remove(allChefRating);
		allChefRating.setBookingDetail(null);

		return allChefRating;
	}

	public List<AllPayment> getAllPayments() {
		return this.allPayments;
	}

	public void setAllPayments(List<AllPayment> allPayments) {
		this.allPayments = allPayments;
	}

	public AllPayment addAllPayment(AllPayment allPayment) {
		getAllPayments().add(allPayment);
		allPayment.setBookingDetail(this);

		return allPayment;
	}

	public AllPayment removeAllPayment(AllPayment allPayment) {
		getAllPayments().remove(allPayment);
		allPayment.setBookingDetail(null);

		return allPayment;
	}

	public ChefDetail getChefDetail() {
		return this.chefDetail;
	}

	public void setChefDetail(ChefDetail chefDetail) {
		this.chefDetail = chefDetail;
	}

	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public List<BookingExtraDetail> getBookingExtraDetails() {
		return this.bookingExtraDetails;
	}

	public void setBookingExtraDetails(List<BookingExtraDetail> bookingExtraDetails) {
		this.bookingExtraDetails = bookingExtraDetails;
	}

	public BookingExtraDetail addBookingExtraDetail(BookingExtraDetail bookingExtraDetail) {
		getBookingExtraDetails().add(bookingExtraDetail);
		bookingExtraDetail.setBookingDetail(this);

		return bookingExtraDetail;
	}

	public BookingExtraDetail removeBookingExtraDetail(BookingExtraDetail bookingExtraDetail) {
		getBookingExtraDetails().remove(bookingExtraDetail);
		bookingExtraDetail.setBookingDetail(null);

		return bookingExtraDetail;
	}

	public List<ChefEarning> getChefEarnings() {
		return this.chefEarnings;
	}

	public void setChefEarnings(List<ChefEarning> chefEarnings) {
		this.chefEarnings = chefEarnings;
	}

	public ChefEarning addChefEarning(ChefEarning chefEarning) {
		getChefEarnings().add(chefEarning);
		chefEarning.setBookingDetail(this);

		return chefEarning;
	}

	public ChefEarning removeChefEarning(ChefEarning chefEarning) {
		getChefEarnings().remove(chefEarning);
		chefEarning.setBookingDetail(null);

		return chefEarning;
	}

	public List<UsedCoupon> getUsedCoupons() {
		return this.usedCoupons;
	}

	public void setUsedCoupons(List<UsedCoupon> usedCoupons) {
		this.usedCoupons = usedCoupons;
	}

	public UsedCoupon addUsedCoupon(UsedCoupon usedCoupon) {
		getUsedCoupons().add(usedCoupon);
		usedCoupon.setBookingDetail(this);

		return usedCoupon;
	}

	public UsedCoupon removeUsedCoupon(UsedCoupon usedCoupon) {
		getUsedCoupons().remove(usedCoupon);
		usedCoupon.setBookingDetail(null);

		return usedCoupon;
	}

}