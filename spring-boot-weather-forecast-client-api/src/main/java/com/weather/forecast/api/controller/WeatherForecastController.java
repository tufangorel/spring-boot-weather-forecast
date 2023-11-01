package com.weather.forecast.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weather.forecast.api.model.request.City;
import com.weather.forecast.api.model.response.WeatherForecastResponse;
import com.weather.forecast.api.service.WeatherForecastService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forecast")
public class WeatherForecastController {


    private static final Logger Log = LoggerFactory.getLogger(WeatherForecastController.class);


    private final WeatherForecastService weatherForecastService;

    public WeatherForecastController(WeatherForecastService weatherForecastService) {
        this.weatherForecastService = weatherForecastService;
    }

    @Operation(summary = "Get Weather Forecast By City Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved maxFeelsLike and maxHumidity"),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
    })
    @PostMapping("/by-city-id")
    public ResponseEntity<WeatherForecastResponse> getWeatherForecastByCityId(@RequestBody City city) throws JsonProcessingException {

        Long cityId = city.getCityId();
        if( cityId != null ) {
            Log.info("Fetching weather details with cityId: {}", cityId);
            WeatherForecastResponse weatherForecastResponse = weatherForecastService.getWeatherForecastByCityId(cityId);
            if (weatherForecastResponse != null) {
                return new ResponseEntity<>(weatherForecastResponse, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Get Weather Forecast By City Id and access token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved maxFeelsLike and maxHumidity"),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
    })
    @GetMapping("/get/{cityId}/{appId}")
    public ResponseEntity<WeatherForecastResponse> getWeatherForecastByCityIdAndAppID( @PathVariable("cityId") String cityId,
                                                              @PathVariable("appId") String appId) throws JsonProcessingException {

        Log.info("Fetching weather details with cityId: {}", cityId);

        WeatherForecastResponse weatherForecastResponse = weatherForecastService.getWeatherForecastByCityIdAndAppID(cityId, appId);

        if (weatherForecastResponse != null) {
            return new ResponseEntity<>(weatherForecastResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/get/{cityId}")
    public ResponseEntity<WeatherForecastResponse> getWeatherForecastByCityIdAndAppIDWithHeader( @PathVariable("cityId") String cityId,
                                                                        @RequestHeader(value="Authorization") String authorizationHeader ) throws JsonProcessingException {
        Log.info("Fetching weather details with cityId: {}", cityId);
        String appId = authorizationHeader;
        WeatherForecastResponse weatherForecastResponse = weatherForecastService.getWeatherForecastByCityIdAndAppID(cityId, appId);

        if (weatherForecastResponse != null) {
            return new ResponseEntity<>(weatherForecastResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}