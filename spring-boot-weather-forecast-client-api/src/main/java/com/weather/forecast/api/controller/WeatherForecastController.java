package com.weather.forecast.api.controller;

import com.weather.forecast.api.model.request.City;
import com.weather.forecast.api.model.response.WeatherForecastResponse;
import com.weather.forecast.api.service.WeatherForecastService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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

    @Operation(summary = "Get Weather Forecast By City Id provided in http body")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved maxFeelsLike and maxHumidity"),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found"),
            @ApiResponse(responseCode = "500", description = "City value can not be null")
    })
    @PostMapping("/by-city-id")
    public ResponseEntity<?> getWeatherForecastByCityId(@RequestBody City city) throws Exception {

        if( city != null && city.getCityId() != null ) {
            Long cityId = city.getCityId();
            Log.info("Fetching weather details with cityId: {}", cityId);
            WeatherForecastResponse weatherForecastResponse = weatherForecastService.getWeatherForecastByCityId(cityId);
            if (weatherForecastResponse != null) {
                return new ResponseEntity<>(weatherForecastResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        return new ResponseEntity<String>("City value can not be null", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Operation(summary = "Get Weather Forecast By City Id and access token provided in query string")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved maxFeelsLike and maxHumidity"),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found"),
            @ApiResponse(responseCode = "500", description = "City value and appId can not be null")
    })
    @GetMapping("/get/{cityId}/{appId}")
    public ResponseEntity<?> getWeatherForecastByCityIdAndAppID( @PathVariable("cityId") String cityId,
                                                              @PathVariable("appId") String appId) throws Exception {

        if( cityId != null && appId != null ) {
            Log.info("Fetching weather details with cityId: {}", cityId);
            WeatherForecastResponse weatherForecastResponse = weatherForecastService.getWeatherForecastByCityIdAndAppID(cityId, appId);

            if (weatherForecastResponse != null) {
                return new ResponseEntity<>(weatherForecastResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        return new ResponseEntity<String>("City value and appId can not be null", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Operation(summary = "Get Weather Forecast By City Id and access token provided in http request header")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved maxFeelsLike and maxHumidity"),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found"),
            @ApiResponse(responseCode = "500", description = "City value and authorizationHeader can not be null")
    })
    @GetMapping(path = "/get/{cityId}")
    public ResponseEntity<?> getWeatherForecastByCityIdAndAppIDWithHeader( @PathVariable("cityId") String cityId,
                                                                           @RequestHeader(value="ACCESS-TOKEN") String authorization ) throws Exception {

        if( cityId != null && authorization != null ) {
            Log.info("Fetching weather details with cityId: {}", cityId);
            WeatherForecastResponse weatherForecastResponse = weatherForecastService.getWeatherForecastByCityIdAndAppID(cityId, authorization);

            if (weatherForecastResponse != null) {
                return new ResponseEntity<>(weatherForecastResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        return new ResponseEntity<String>("City value and authorizationHeader can not be null", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}