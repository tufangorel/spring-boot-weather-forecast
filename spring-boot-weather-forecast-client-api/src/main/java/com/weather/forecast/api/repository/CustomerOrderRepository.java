package com.weather.forecast.api.repository;

import com.weather.forecast.api.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {


}

