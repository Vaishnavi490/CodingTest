package com.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.dao.CreditDao;
import com.model.Credit;

@Service

public class CreditServiceImpl implements CreditService {

	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {

		return new RestTemplate();
	}

	@Autowired
	public CreditDao creditDao;

	public String createCredit(Credit credit) throws InsufficientCreditScoreException,  DateException {

		credit = creditDao.save(credit);
		return getCreditScore(credit.getSsnNumber(), credit.getCurrentAnualIncome());

	}

	public String getCreditScore(int ssnNumber1, long currentAnualIncome1)
			throws InsufficientCreditScoreException/* , DateException */, DateException{
		String ssnNumber = "" + ssnNumber1;
		String currentAnualIncome = "" + currentAnualIncome1;
		String url = "http://localhost:8043/getCredit";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		Map<String, String> params = new HashMap<String, String>();
		params.put("ssnNumber", ssnNumber);
		params.put("currentAnualIncome", currentAnualIncome);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		for (Map.Entry<String, String> entry : params.entrySet()) {
			builder.queryParam(entry.getKey(), entry.getValue());
		}
		String result = null;
		try {
			result = restTemplate.getForObject(builder.toUriString(), String.class);
		} 
		catch ( HttpClientErrorException httpClientErrorException) {

			throw new InsufficientCreditScoreException();
		}
		
		  catch ( Exception Exception) {
			  throw new DateException(); 
			}
		 
		return result;
	}

}
