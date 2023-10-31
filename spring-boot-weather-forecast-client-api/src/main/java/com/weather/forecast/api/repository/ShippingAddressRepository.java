package com.weather.forecast.api.repository;


import com.weather.forecast.api.model.Customer;
import com.weather.forecast.api.model.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Integer> {

    @Query("SELECT s.customer FROM ShippingAddress s WHERE s.id = :shippingAddressID")
    Customer findCustomerByShippingAddressID(Integer shippingAddressID);

}