package com.controller;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.service.DateException;
import com.service.InsufficientCreditScoreException;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	
	
	  @ExceptionHandler(DateException.class) public ResponseEntity<Object>
	  dateException(DateException ex,WebRequest request) {
	  
	  Map<String, Object> body = new LinkedHashMap<>();
	  
	  body.put("message",
	  "Applicant having same ssnNumber can be applied after 30 days");
	  
	  return new ResponseEntity<>(body, HttpStatus.NOT_FOUND); }
	 
	@ExceptionHandler(InsufficientCreditScoreException.class)
	public ResponseEntity<Object> insufficientCreditScoreException(InsufficientCreditScoreException ex,
			WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		
		body.put("message", "Credit Score is less than 700");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	  @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(
	        MethodArgumentNotValidException ex, HttpHeaders headers, 
	        HttpStatus status, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDate.now());
	        body.put("status", status.value());

	        List<String> errors = ex.getBindingResult()
	                .getFieldErrors()
	                .stream()
	                .map(x -> x.getDefaultMessage())
	                .collect(Collectors.toList());

	        body.put("errors", errors);

	        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	    }
	  
	 
	

}