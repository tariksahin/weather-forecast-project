package com.ing.weatherforecast.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WeatherForecastCouldntReceivedException extends RuntimeException {

    public WeatherForecastCouldntReceivedException(String cityName) {
        super("Weather forecast information could not be received for city: " + cityName);
    }
}
