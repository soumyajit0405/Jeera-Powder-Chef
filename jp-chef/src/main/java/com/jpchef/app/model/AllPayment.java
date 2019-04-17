package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the all_payments database table.
 * 
 */
@Entity
@Table(name="all_payments")
@NamedQuery(name="AllPayment.findAll", query="SELECT a FROM AllPayment a")
public class AllPayment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="payment_id")
	private Long paymentId;

	private BigDecimal attempt;

	@Column(name="payment_mode")
	private Integer paymentMode;

	@Column(name="payment_status")
	private Integer paymentStatus;

	@Column(name="payment_time")
	private Timestamp paymentTime;

	@Column(name="refund_request_ref_key")
	private Long refundRequestRefKey;

	@Column(name="third_party_provider")
	private Integer thirdPartyProvider;

	@Column(name="total_amount_paid")
	private double totalAmountPaid;

	@Column(name="trans_ref_key")
	private Long transRefKey;

	@Column(name="transaction_comment")
	private String transactionComment;

	//bi-directional many-to-one association to BookingDetail
	@ManyToOne
	@JoinColumn(name="booking_id")
	private BookingDetail bookingDetail;

	//bi-directional many-to-one association to PaymentBreakdown
	@OneToMany(mappedBy="allPayment")
	private List<PaymentBreakdown> paymentBreakdowns;

	public AllPayment() {
	}

	public Long getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public BigDecimal getAttempt() {
		return this.attempt;
	}

	public void setAttempt(BigDecimal attempt) {
		this.attempt = attempt;
	}

	public Integer getPaymentMode() {
		return this.paymentMode;
	}

	public void setPaymentMode(Integer paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Integer getPaymentStatus() {
		return this.paymentStatus;
	}

	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Timestamp getPaymentTime() {
		return this.paymentTime;
	}

	public void setPaymentTime(Timestamp paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Long getRefundRequestRefKey() {
		return this.refundRequestRefKey;
	}

	public void setRefundRequestRefKey(Long refundRequestRefKey) {
		this.refundRequestRefKey = refundRequestRefKey;
	}

	public Integer getThirdPartyProvider() {
		return this.thirdPartyProvider;
	}

	public void setThirdPartyProvider(Integer thirdPartyProvider) {
		this.thirdPartyProvider = thirdPartyProvider;
	}

	public double getTotalAmountPaid() {
		return this.totalAmountPaid;
	}

	public void setTotalAmountPaid(double totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}

	public Long getTransRefKey() {
		return this.transRefKey;
	}

	public void setTransRefKey(Long transRefKey) {
		this.transRefKey = transRefKey;
	}

	public String getTransactionComment() {
		return this.transactionComment;
	}

	public void setTransactionComment(String transactionComment) {
		this.transactionComment = transactionComment;
	}

	public BookingDetail getBookingDetail() {
		return this.bookingDetail;
	}

	public void setBookingDetail(BookingDetail bookingDetail) {
		this.bookingDetail = bookingDetail;
	}

	public List<PaymentBreakdown> getPaymentBreakdowns() {
		return this.paymentBreakdowns;
	}

	public void setPaymentBreakdowns(List<PaymentBreakdown> paymentBreakdowns) {
		this.paymentBreakdowns = paymentBreakdowns;
	}

	public PaymentBreakdown addPaymentBreakdown(PaymentBreakdown paymentBreakdown) {
		getPaymentBreakdowns().add(paymentBreakdown);
		paymentBreakdown.setAllPayment(this);

		return paymentBreakdown;
	}

	public PaymentBreakdown removePaymentBreakdown(PaymentBreakdown paymentBreakdown) {
		getPaymentBreakdowns().remove(paymentBreakdown);
		paymentBreakdown.setAllPayment(null);

		return paymentBreakdown;
	}

}