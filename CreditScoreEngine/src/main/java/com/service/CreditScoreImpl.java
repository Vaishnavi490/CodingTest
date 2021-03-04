package com.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CreditScoreEngineDao;
import com.model.CreditScore;
import com.model.ErrorStatus;

@Service
public class CreditScoreImpl implements CreditScoreService {
	
	@Autowired
	private CreditScoreEngineDao creditScoreEngineDao;
	public  CreditScore getCredit(int ssnNumber, long currentAnualIncome) throws InsufficientCreditScoreException, DateException {
		
		//ErrorStatus errorMessage;
		CreditScore	 creditScore=creditScoreEngineDao.findById(ssnNumber).get();
		
		if(creditScore.getDate().compareTo(LocalDate.now())<0  || creditScore.getDate()==null ) {
		
		if (creditScore.getCreditScore() > 700  ) 
		{
			
			creditScore.setSanctionedAmount(currentAnualIncome / 2);
			
			creditScore.setDate(LocalDate.now());
			creditScoreEngineDao.save(creditScore);
		}
		else {
			
			
			 throw new InsufficientCreditScoreException(creditScore);
			
			}
		}
		else
		{
			throw new DateException();
		}
		return creditScore;
		
	}

}
 