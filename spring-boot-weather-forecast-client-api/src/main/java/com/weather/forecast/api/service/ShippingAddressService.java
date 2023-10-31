package com.weather.forecast.api.service;

import com.weather.forecast.api.model.Customer;
import com.weather.forecast.api.repository.ShippingAddressRepository;
import org.springframework.stereotype.Service;

@Service
public class ShippingAddressService {

    private final ShippingAddressRepository shippingAddressRepository;

    public ShippingAddressService(ShippingAddressRepository shippingAddressRepository) {
        this.shippingAddressRepository = shippingAddressRepository;
    }

    public Customer findCustomerByShippingAddressID(Integer shippingAddressID) {
        return shippingAddressRepository.findCustomerByShippingAddressID(shippingAddressID);
    }
}
