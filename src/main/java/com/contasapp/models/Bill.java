package com.contasapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codeBill;
	
	private String billName;
	
	private String note;
	
	private double value;
	
	@Column(name="payment_id", insertable =  false , updatable = false, nullable = false, unique = false)
	private Long payment_id;
	
	@ManyToOne
	private Payment payment;

	public Long getCodeBill() {
		return codeBill;
	}

	public void setCodeBill(Long codeBill) {
		this.codeBill = codeBill;
	}

	public Long getId() {
		return codeBill;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public void setId(long id) {
		this.codeBill = id;
	}

	public String getBillName() {
		return billName;
	}

	public void setBillName(String billName) {
		this.billName = billName;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getPaymentCode() {
		return payment_id;
	}

	public void setPaymentCode(Long paymentCode) {
		this.payment_id = paymentCode;
	}

	
}
