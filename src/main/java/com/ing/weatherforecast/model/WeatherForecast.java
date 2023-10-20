package com.ing.weatherforecast.model;

import java.time.LocalDate;



public class WeatherForecast {

    private String city;
    private LocalDate date;
    private double maxTemperatureKelvin;
    private double feelsLikeTemperatureKelvin;
    private int humidity;
    private double maxTemperatureCelsius;
    private double feelsLikeTemperatureCelsius;

    public WeatherForecast(String city, LocalDate date, double maxTemperatureKelvin, double feelsLikeTemperatureKelvin, int humidity) {
        this.city = city;
        this.date = date;
        this.maxTemperatureKelvin = maxTemperatureKelvin;
        this.feelsLikeTemperatureKelvin = feelsLikeTemperatureKelvin;
        this.maxTemperatureCelsius = Math.round((maxTemperatureKelvin - 273.15) * 100.0) / 100.0; //kelvin to celsius migration permanent values
        this.feelsLikeTemperatureCelsius = Math.round((feelsLikeTemperatureKelvin - 273.15) * 100.0) / 100.0; //kelvin to celsius migration permanent values
        this.humidity = humidity;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getMaxTemperatureKelvin() {
        return maxTemperatureKelvin;
    }

    public double getFeelsLikeTemperatureKelvin() {
        return feelsLikeTemperatureKelvin;
    }

    public double getMaxTemperatureCelsius() {
        return maxTemperatureCelsius;
    }

    public double getFeelsLikeTemperatureCelsius() {
        return feelsLikeTemperatureCelsius;
    }
    public int getHumidity() {
        return humidity;
    }


}
