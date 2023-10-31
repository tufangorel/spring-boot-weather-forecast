package com.weather.forecast.api.mapper;


import com.weather.forecast.api.dto.CustomerDTO;
import com.weather.forecast.api.model.Customer;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toCustomerDTO(Customer customer);

    Customer customerDTOToCustomer(CustomerDTO customerDTO);

    Iterable<CustomerDTO> customersToCustomerAllDtos(Iterable<Customer> customers);
}
