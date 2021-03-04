package com.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class CreditScore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ssnNumber;
	@JsonIgnore
	private long creditScore;
	private long sanctionedAmount;
	
	

	@JsonIgnore
	private LocalDate date;

	public long getSanctionedAmount() {
		return sanctionedAmount;
	}

	public void setSanctionedAmount(long sanctionedAmount) {
		this.sanctionedAmount = sanctionedAmount;
	}

	public CreditScore(int ssnNumber, long creditScore) {
		super();
		this.ssnNumber = ssnNumber;
		this.creditScore = creditScore;
	}

	public int getSsnNumber() {
		return ssnNumber;
	}

	public void setSsnNumber(int ssnNumber) {
		this.ssnNumber = ssnNumber;
	}

	public long getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(long creditScore) {
		this.creditScore = creditScore;
	}

	public CreditScore() {
		super();
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}