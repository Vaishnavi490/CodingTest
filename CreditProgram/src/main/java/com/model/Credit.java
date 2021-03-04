package com.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Credit {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	int ssnNumber ;
	double loanAmount;
	long currentAnualIncome;
	
	
	
	
	public int getSsnNumber() {
		return ssnNumber;
	}
	public void setSsnNumber(int ssnNumber) {
		this.ssnNumber = ssnNumber;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public long getCurrentAnualIncome() {
		return currentAnualIncome;
	}
	public void setCurrentAnualIncome(long currentAnualIncome) {
		this.currentAnualIncome = currentAnualIncome;
	}

	
	public Credit() {
		super();
		
	}
	public Credit(int ssnNumber, double loanAmount, long currentAnualIncome) {
		super();
		this.ssnNumber = ssnNumber;
		this.loanAmount = loanAmount;
		this.currentAnualIncome = currentAnualIncome;
		
	}
	
	

	

}