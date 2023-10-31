package com.weather.forecast.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Weather {

    private long dt;
    private Main main;
    private List<DetailInfo> weather;
    private Clouds clouds;
    private Wind wind;
    private int visibility;
    private long pop;
    private Sys sys;
    private String dt_txt;

}
