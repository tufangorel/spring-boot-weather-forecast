package com.weather.forecast.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetailInfo {

  private int id;
  private String main;
  private String description;
  private String icon;

}
