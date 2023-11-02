package com.weather.forecast.api.model;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {

    private int cod;
    private String message;
    private int cnt;
    private City city;

    private List<Weather> list = new ArrayList<>();

}
