package com.weather.forecast.api.repository.integration.test;


import com.weather.forecast.api.WeatherForecastClientAPI;
import com.weather.forecast.api.model.Address;
import com.weather.forecast.api.repository.AddressRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = WeatherForecastClientAPI.class)
public class AddressRepositoryIntegrationTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void shouldSaveAddress() {

        Address address = new Address();
        address.setCountry("TR");
        address.setCity("Ankara");
        address.setStreetName("KaleSokak");

        Address savedAddress = addressRepository.save(address);
        assertThat(savedAddress).isEqualTo(address);
    }

}
