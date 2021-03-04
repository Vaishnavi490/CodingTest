package com.service;

import com.model.CreditScore;

@SuppressWarnings("serial")
public class InsufficientCreditScoreException extends RuntimeException {

	public InsufficientCreditScoreException(CreditScore creditScore) {
		//super("Credit Score is less than 500");
	}
	 
	

}
