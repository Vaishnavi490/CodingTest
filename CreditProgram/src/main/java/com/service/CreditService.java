package com.service;



import com.model.Credit;

public interface CreditService {

	String createCredit(Credit credit) throws InsufficientCreditScoreException, DateException;
	String getCreditScore(int ssnNumber, long currentAnualIncome) throws InsufficientCreditScoreException, DateException ;

	
	
	
	




	
}
