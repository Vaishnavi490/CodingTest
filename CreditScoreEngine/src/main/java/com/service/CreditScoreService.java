package com.service;

import com.model.CreditScore;

public interface CreditScoreService {
	public  abstract CreditScore getCredit(int ssnNumber, long currentAnualIncome) throws InsufficientCreditScoreException, DateException;
	

}
