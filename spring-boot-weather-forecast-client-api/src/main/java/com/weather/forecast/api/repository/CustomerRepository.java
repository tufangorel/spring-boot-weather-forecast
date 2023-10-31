package com.weather.forecast.api.repository;

import com.weather.forecast.api.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}

