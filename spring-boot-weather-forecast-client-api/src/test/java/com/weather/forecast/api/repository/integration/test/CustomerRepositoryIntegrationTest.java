package com.weather.forecast.api.repository.integration.test;

import com.weather.forecast.api.WeatherForecastClientAPI;
import com.weather.forecast.api.model.Address;
import com.weather.forecast.api.model.Customer;
import com.weather.forecast.api.model.ShippingAddress;
import com.weather.forecast.api.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = WeatherForecastClientAPI.class)
@ActiveProfiles("test")
public class CustomerRepositoryIntegrationTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void shouldSaveUser() {
        Customer customer = new Customer();
        customer.setName("name1");
        customer.setAge(1);

        ShippingAddress shippingAddress = new ShippingAddress();
        Address address = new Address();
        address.setCountry("TR");
        address.setCity("Ankara");
        address.setStreetName("KaleSokak");
        shippingAddress.setAddress(address);
        customer.setShippingAddress(shippingAddress);

        Customer savedCustomer = customerRepository.save(customer);
        assertThat(savedCustomer).isEqualTo(customer);
    }

}