package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.CreditScore;
import com.service.CreditScoreService;
import com.service.DateException;
import com.service.InsufficientCreditScoreException;

@RestController
public class Controller {
	
	@Autowired
	private CreditScoreService creditScoreService;
	
	@GetMapping("/test")
	public ResponseEntity<Void> test() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getCredit")
	public CreditScore getCreditScore(@RequestParam(name = "ssnNumber") int ssnNumber , @RequestParam(name = "currentAnualIncome") long currentAnualIncome) throws InsufficientCreditScoreException, DateException {
		System.out.println("credit engine controller");
		
		return creditScoreService.getCredit(ssnNumber,currentAnualIncome) ;
		

	}

}
