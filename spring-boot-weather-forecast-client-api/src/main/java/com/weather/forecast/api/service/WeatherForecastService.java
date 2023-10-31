package com.weather.forecast.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.forecast.api.model.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherForecastService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherForecastService.class.getName());

    private final String API_KEY;
    private final String apiUrl;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public WeatherForecastService(RestTemplate restTemplate, ObjectMapper objectMapper, Environment environment) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.API_KEY = environment.getProperty("openweathermap.api.key");
        this.apiUrl = environment.getProperty("openweathermap.api.url");
    }

    public WeatherResponse getWeatherForecastByCityId(long cityId) {
        String url = apiUrl + "?id=" + cityId + "&appid=" + API_KEY;
        return getWeatherResponse(url);
    }

    private WeatherResponse getWeatherResponse(String url) {
        String response = restTemplate.getForObject(url, String.class);

        try {
            return objectMapper.readValue(response, WeatherResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
