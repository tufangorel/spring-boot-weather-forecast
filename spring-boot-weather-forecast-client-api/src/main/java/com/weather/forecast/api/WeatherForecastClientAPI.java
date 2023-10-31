package com.weather.forecast.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class WeatherForecastClientAPI {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherForecastClientAPI.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(WeatherForecastClientAPI.class, args);
    }

}
