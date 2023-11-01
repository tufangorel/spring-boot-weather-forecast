package com.weather.forecast.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherForecastResponse {

    private double maxFeelsLike;
    private int maxHumidity;


}
