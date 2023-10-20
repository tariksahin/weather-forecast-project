package com.ing.weatherforecast;

import com.ing.weatherforecast.model.Main;
import com.ing.weatherforecast.model.WeatherApiResponse;
import com.ing.weatherforecast.model.WeatherForecast;
import com.ing.weatherforecast.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class WeatherforecastApplicationTests {

	@Mock
	private RestTemplate restTemplate;

	@Autowired
	private WeatherService weatherService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetWeatherForecast() {

		//Creating a mock WeatherApiResponse with Main
		WeatherApiResponse mockApiResponse = new WeatherApiResponse();
		Main mockMain = new Main();
		mockMain.setTemp_max(295.81);
		mockMain.setFeels_like(295.7);
		mockMain.setHumidity(60);
		mockApiResponse.setMain(mockMain);

		//Defining the expected values for the test
		String expectedCity = "Istanbul";
		LocalDate expectedDate = LocalDate.now();
		double expectedMaxTemperature = 293.25;
		double expectedFeelsLikeTemperature = 291.82;
		int expectedHumidity = 60;


		when(restTemplate.getForObject(any(String.class), any())).thenReturn(mockApiResponse);
		WeatherForecast weatherForecast = weatherService.getWeatherForecast(expectedCity);

		//Verify that the result matches with the expected values
		assertEquals(expectedCity, weatherForecast.getCity());
		assertEquals(expectedDate, weatherForecast.getDate());
		assertEquals(expectedMaxTemperature, weatherForecast.getMaxTemperatureKelvin(), 0.01);
		assertEquals(expectedFeelsLikeTemperature, weatherForecast.getFeelsLikeTemperatureKelvin(), 0.01);
		assertEquals(expectedHumidity, weatherForecast.getHumidity());
	}
}
