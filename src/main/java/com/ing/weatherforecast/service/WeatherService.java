    package com.ing.weatherforecast.service;

    import com.ing.weatherforecast.exception.WeatherForecastCouldntReceivedException;
    import com.ing.weatherforecast.model.WeatherApiResponse;
    import com.ing.weatherforecast.model.WeatherForecast;
    import org.springframework.stereotype.Service;
    import org.springframework.web.client.RestTemplate;
    import org.springframework.web.util.UriComponentsBuilder;

    import java.time.LocalDate;

    @Service
    public class WeatherService {

        private final RestTemplate restTemplate;

        public WeatherService(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }


        private String apiKey = "5248854d717678e18afe5121cd9caf90";


        private String baseUrl = "https://api.openweathermap.org";

        public WeatherForecast getWeatherForecast(String city) {

            String url = UriComponentsBuilder.fromUriString(baseUrl).path("/data/2.5/weather").queryParam("q", city).queryParam("appid", apiKey).toUriString();
            // String url = "https://api.openweathermap.org/data/2.5/weather?q=Istanbul&appid=5248854d717678e18afe5121cd9caf90"; //for test

            WeatherApiResponse response;
            try {
                response = restTemplate.getForObject(url, WeatherApiResponse.class);
            } catch (Exception ex) {
                throw new WeatherForecastCouldntReceivedException(city);
            }
            if (response != null) {
                WeatherForecast weatherForecast = new WeatherForecast(
                        response.getName(),
                        LocalDate.now(),
                        response.getMain().getTemp_max(),
                        response.getMain().getFeels_like(),
                        response.getMain().getHumidity()
                );
                return weatherForecast;
            } else {
                return null;
            }

        }
    }




