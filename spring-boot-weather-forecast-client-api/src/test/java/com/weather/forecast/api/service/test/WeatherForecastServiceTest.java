package com.weather.forecast.api.service.test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.forecast.api.WeatherForecastClientAPI;
import com.weather.forecast.api.model.response.WeatherForecastResponse;
import com.weather.forecast.api.service.WeatherForecastService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= WeatherForecastClientAPI.class)
public class WeatherForecastServiceTest {

    @Autowired
    private WeatherForecastService weatherForecastService;
    @Autowired
    private Environment environment;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getWeatherForecastByCityIdTest() throws JsonProcessingException {

        WeatherForecastResponse expectedWeatherForecastResponse = new WeatherForecastResponse();
        expectedWeatherForecastResponse.setMaxHumidity(88);
        expectedWeatherForecastResponse.setMaxFeelsLike(278.74);

        WeatherForecastResponse weatherForecastResponse = weatherForecastService.getWeatherForecastByCityId(524901);
        Assertions.assertNotNull(weatherForecastResponse);
        Assertions.assertEquals( weatherForecastResponse.getMaxFeelsLike(), 278.74 );
        Assertions.assertEquals( weatherForecastResponse.getMaxHumidity(), 88 );
    }


}
