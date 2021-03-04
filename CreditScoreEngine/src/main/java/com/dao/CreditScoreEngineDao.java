package com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.CreditScore;

@Repository
public interface CreditScoreEngineDao  extends CrudRepository<CreditScore, Integer>{

}
