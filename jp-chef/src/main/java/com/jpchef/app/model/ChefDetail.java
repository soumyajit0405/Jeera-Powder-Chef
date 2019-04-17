package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;

import org.postgresql.geometric.PGpoint;

import java.util.List;


/**
 * The persistent class for the chef_details database table.
 * 
 */
@Entity
@Table(name="chef_details")
@NamedQuery(name="ChefDetail.findAll", query="SELECT c FROM ChefDetail c")
public class ChefDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="chef_id")
	private Long chefId;

	@Column(name="availability_flag")
	private Boolean availabilityFlag;

	@Column(name="chef_category")
	private Integer chefCategory;

	@Column(name="chef_image")
	private String chefImage;

	@Column(name="chef_location")
	private PGpoint chefLocation;

	@Column(name="chef_type")
	private Integer chefType;

	private String comments;

	@Column(name="full_name")
	private String fullName;

	@Column(name="phone_number")
	private String phoneNumber;

	private String qualification;

	private String specialization;

	//bi-directional many-to-one association to AllChefRating
	@OneToMany(mappedBy="chefDetail")
	private List<AllChefRating> allChefRatings;

	//bi-directional many-to-one association to BankDetail
	@OneToMany(mappedBy="chefDetail")
	private List<BankDetail> bankDetails;

	//bi-directional many-to-one association to BookingDetail
	@OneToMany(mappedBy="chefDetail")
	private List<BookingDetail> bookingDetails;

	//bi-directional many-to-one association to ChefAvailabilityTracker
	@OneToMany(mappedBy="chefDetail")
	private List<ChefAvailabilityTracker> chefAvailabilityTrackers;

	//bi-directional many-to-one association to ChefCommission
	@OneToMany(mappedBy="chefDetail")
	private List<ChefCommission> chefCommissions;

	//bi-directional many-to-one association to ChefDishMapping
	@OneToMany(mappedBy="chefDetail")
	private List<ChefDishMapping> chefDishMappings;

	//bi-directional many-to-one association to ChefEarning
	@OneToMany(mappedBy="chefDetail")
	private List<ChefEarning> chefEarnings;

	//bi-directional many-to-one association to ChefExtraDetail
	@OneToMany(mappedBy="chefDetail")
	private List<ChefExtraDetail> chefExtraDetails;

	//bi-directional many-to-one association to ChefLanguage
	@OneToMany(mappedBy="chefDetail")
	private List<ChefLanguage> chefLanguages;

	//bi-directional many-to-one association to ChefPayout
	@OneToMany(mappedBy="chefDetail")
	private List<ChefPayout> chefPayouts;

	//bi-directional many-to-one association to GeneralChefRating
	@OneToMany(mappedBy="chefDetail")
	private List<GeneralChefRating> generalChefRatings;

	public ChefDetail() {
	}

	public Long getChefId() {
		return this.chefId;
	}

	public void setChefId(Long chefId) {
		this.chefId = chefId;
	}

	public Boolean getAvailabilityFlag() {
		return this.availabilityFlag;
	}

	public void setAvailabilityFlag(Boolean availabilityFlag) {
		this.availabilityFlag = availabilityFlag;
	}

	public Integer getChefCategory() {
		return this.chefCategory;
	}

	public void setChefCategory(Integer chefCategory) {
		this.chefCategory = chefCategory;
	}

	public String getChefImage() {
		return this.chefImage;
	}

	public void setChefImage(String chefImage) {
		this.chefImage = chefImage;
	}

	public PGpoint getChefLocation() {
		return this.chefLocation;
	}

	public void setChefLocation(PGpoint chefLocation) {
		this.chefLocation = chefLocation;
	}

	public Integer getChefType() {
		return this.chefType;
	}

	public void setChefType(Integer chefType) {
		this.chefType = chefType;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getQualification() {
		return this.qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSpecialization() {
		return this.specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public List<AllChefRating> getAllChefRatings() {
		return this.allChefRatings;
	}

	public void setAllChefRatings(List<AllChefRating> allChefRatings) {
		this.allChefRatings = allChefRatings;
	}

	public AllChefRating addAllChefRating(AllChefRating allChefRating) {
		getAllChefRatings().add(allChefRating);
		allChefRating.setChefDetail(this);

		return allChefRating;
	}

	public AllChefRating removeAllChefRating(AllChefRating allChefRating) {
		getAllChefRatings().remove(allChefRating);
		allChefRating.setChefDetail(null);

		return allChefRating;
	}

	public List<BankDetail> getBankDetails() {
		return this.bankDetails;
	}

	public void setBankDetails(List<BankDetail> bankDetails) {
		this.bankDetails = bankDetails;
	}

	public BankDetail addBankDetail(BankDetail bankDetail) {
		getBankDetails().add(bankDetail);
		bankDetail.setChefDetail(this);

		return bankDetail;
	}

	public BankDetail removeBankDetail(BankDetail bankDetail) {
		getBankDetails().remove(bankDetail);
		bankDetail.setChefDetail(null);

		return bankDetail;
	}

	public List<BookingDetail> getBookingDetails() {
		return this.bookingDetails;
	}

	public void setBookingDetails(List<BookingDetail> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	public BookingDetail addBookingDetail(BookingDetail bookingDetail) {
		getBookingDetails().add(bookingDetail);
		bookingDetail.setChefDetail(this);

		return bookingDetail;
	}

	public BookingDetail removeBookingDetail(BookingDetail bookingDetail) {
		getBookingDetails().remove(bookingDetail);
		bookingDetail.setChefDetail(null);

		return bookingDetail;
	}

	public List<ChefAvailabilityTracker> getChefAvailabilityTrackers() {
		return this.chefAvailabilityTrackers;
	}

	public void setChefAvailabilityTrackers(List<ChefAvailabilityTracker> chefAvailabilityTrackers) {
		this.chefAvailabilityTrackers = chefAvailabilityTrackers;
	}

	public ChefAvailabilityTracker addChefAvailabilityTracker(ChefAvailabilityTracker chefAvailabilityTracker) {
		getChefAvailabilityTrackers().add(chefAvailabilityTracker);
		chefAvailabilityTracker.setChefDetail(this);

		return chefAvailabilityTracker;
	}

	public ChefAvailabilityTracker removeChefAvailabilityTracker(ChefAvailabilityTracker chefAvailabilityTracker) {
		getChefAvailabilityTrackers().remove(chefAvailabilityTracker);
		chefAvailabilityTracker.setChefDetail(null);

		return chefAvailabilityTracker;
	}

	public List<ChefCommission> getChefCommissions() {
		return this.chefCommissions;
	}

	public void setChefCommissions(List<ChefCommission> chefCommissions) {
		this.chefCommissions = chefCommissions;
	}

	public ChefCommission addChefCommission(ChefCommission chefCommission) {
		getChefCommissions().add(chefCommission);
		chefCommission.setChefDetail(this);

		return chefCommission;
	}

	public ChefCommission removeChefCommission(ChefCommission chefCommission) {
		getChefCommissions().remove(chefCommission);
		chefCommission.setChefDetail(null);

		return chefCommission;
	}

	public List<ChefDishMapping> getChefDishMappings() {
		return this.chefDishMappings;
	}

	public void setChefDishMappings(List<ChefDishMapping> chefDishMappings) {
		this.chefDishMappings = chefDishMappings;
	}

	public ChefDishMapping addChefDishMapping(ChefDishMapping chefDishMapping) {
		getChefDishMappings().add(chefDishMapping);
		chefDishMapping.setChefDetail(this);

		return chefDishMapping;
	}

	public ChefDishMapping removeChefDishMapping(ChefDishMapping chefDishMapping) {
		getChefDishMappings().remove(chefDishMapping);
		chefDishMapping.setChefDetail(null);

		return chefDishMapping;
	}

	public List<ChefEarning> getChefEarnings() {
		return this.chefEarnings;
	}

	public void setChefEarnings(List<ChefEarning> chefEarnings) {
		this.chefEarnings = chefEarnings;
	}

	public ChefEarning addChefEarning(ChefEarning chefEarning) {
		getChefEarnings().add(chefEarning);
		chefEarning.setChefDetail(this);

		return chefEarning;
	}

	public ChefEarning removeChefEarning(ChefEarning chefEarning) {
		getChefEarnings().remove(chefEarning);
		chefEarning.setChefDetail(null);

		return chefEarning;
	}

	public List<ChefExtraDetail> getChefExtraDetails() {
		return this.chefExtraDetails;
	}

	public void setChefExtraDetails(List<ChefExtraDetail> chefExtraDetails) {
		this.chefExtraDetails = chefExtraDetails;
	}

	public ChefExtraDetail addChefExtraDetail(ChefExtraDetail chefExtraDetail) {
		getChefExtraDetails().add(chefExtraDetail);
		chefExtraDetail.setChefDetail(this);

		return chefExtraDetail;
	}

	public ChefExtraDetail removeChefExtraDetail(ChefExtraDetail chefExtraDetail) {
		getChefExtraDetails().remove(chefExtraDetail);
		chefExtraDetail.setChefDetail(null);

		return chefExtraDetail;
	}

	public List<ChefLanguage> getChefLanguages() {
		return this.chefLanguages;
	}

	public void setChefLanguages(List<ChefLanguage> chefLanguages) {
		this.chefLanguages = chefLanguages;
	}

	public ChefLanguage addChefLanguage(ChefLanguage chefLanguage) {
		getChefLanguages().add(chefLanguage);
		chefLanguage.setChefDetail(this);

		return chefLanguage;
	}

	public ChefLanguage removeChefLanguage(ChefLanguage chefLanguage) {
		getChefLanguages().remove(chefLanguage);
		chefLanguage.setChefDetail(null);

		return chefLanguage;
	}

	public List<ChefPayout> getChefPayouts() {
		return this.chefPayouts;
	}

	public void setChefPayouts(List<ChefPayout> chefPayouts) {
		this.chefPayouts = chefPayouts;
	}

	public ChefPayout addChefPayout(ChefPayout chefPayout) {
		getChefPayouts().add(chefPayout);
		chefPayout.setChefDetail(this);

		return chefPayout;
	}

	public ChefPayout removeChefPayout(ChefPayout chefPayout) {
		getChefPayouts().remove(chefPayout);
		chefPayout.setChefDetail(null);

		return chefPayout;
	}

	public List<GeneralChefRating> getGeneralChefRatings() {
		return this.generalChefRatings;
	}

	public void setGeneralChefRatings(List<GeneralChefRating> generalChefRatings) {
		this.generalChefRatings = generalChefRatings;
	}

	public GeneralChefRating addGeneralChefRating(GeneralChefRating generalChefRating) {
		getGeneralChefRatings().add(generalChefRating);
		generalChefRating.setChefDetail(this);

		return generalChefRating;
	}

	public GeneralChefRating removeGeneralChefRating(GeneralChefRating generalChefRating) {
		getGeneralChefRatings().remove(generalChefRating);
		generalChefRating.setChefDetail(null);

		return generalChefRating;
	}

}