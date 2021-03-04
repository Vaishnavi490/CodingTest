package com.dao;

import org.springframework.data.repository.CrudRepository;

import com.model.Credit;

public interface CreditDao extends CrudRepository<Credit, Integer> {

}
