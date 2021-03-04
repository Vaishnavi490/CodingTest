package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Credit;
import com.service.CreditService;
import com.service.DateException;
import com.service.InsufficientCreditScoreException;

@RestController
public class CreditController {

	@Autowired
	public CreditService creditService ;
	@RequestMapping(value = "/createCredit" , method = RequestMethod.POST)
	public String createApplicant(@RequestBody Credit credit)
			throws InsufficientCreditScoreException, DateException {
		System.out.println("Credit controller");
		return this.creditService.createCredit(credit);
	}
	

}
