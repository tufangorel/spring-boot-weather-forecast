package com.weather.forecast.api.service.test;


import com.weather.forecast.api.WeatherForecastClientAPI;
import com.weather.forecast.api.model.response.WeatherForecastResponse;
import com.weather.forecast.api.service.WeatherForecastService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= WeatherForecastClientAPI.class)
public class WeatherForecastServiceTest {

    @Autowired
    private WeatherForecastService weatherForecastService;

    @Test
    public void getWeatherForecastByCityIdTest()  {

        WeatherForecastResponse expectedWeatherForecastResponse = new WeatherForecastResponse();
        expectedWeatherForecastResponse.setMaxHumidity(93);
        expectedWeatherForecastResponse.setMaxFeelsLike(283.77);

        WeatherForecastResponse weatherForecastResponse = weatherForecastService.getWeatherForecastByCityId(524901);
        Assertions.assertNotNull(weatherForecastResponse);
        Assertions.assertEquals( weatherForecastResponse.getMaxFeelsLike(), 283.77 );
        Assertions.assertEquals( weatherForecastResponse.getMaxHumidity(), 93 );
    }


}
