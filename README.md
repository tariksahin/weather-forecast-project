# Weather Forecast Project

## Table of Contents

- [About the Project](#about-the-project)
- [Tech Stack](#tech-stack)
- [Installation](#installation)
- [Swagger UI](#swagger-ui)
- [Endpoints](#endpoints)
  - [GET Weather Forecast](#get-weather-forecast)
- [Usage](#usage)
- [Testing](#testing)
- [Note](#note)

## About the Project

The Weather Forecast Project provides an API to retrieve weather forecasts for various cities. Users can get the current weather data, including maximum temperature, feels-like temperature, and humidity for a specific city.

## Tech Stack

- Java 11
- Spring Boot
- Maven
- Swagger for API documentation

## Installation

1. Clone the project to your local machine.
2. Open the project in your preferred integrated development environment (IDE) such as IntelliJ or Eclipse.
3. Make sure you have Java 11 installed.
4. Build the project using Maven.
5. Start the application.

## Swagger UI

The Weather Forecast Project offers a Swagger UI for API documentation. You can access it through the following link after starting the application: [Swagger UI](http://localhost:8080/swagger-ui.html)

## Endpoints

The project provides the following endpoint for retrieving weather forecasts:

### GET Weather Forecast

- Endpoint: `GET http://localhost:8080/api/v1/weather/{city}`
- Example URL:
  - `GET http://localhost:8080/api/v1/weather/Istanbul`
  
 - Description: This endpoint returns the weather forecast for the specified city, including the following information:
     - **City Name**
     - **Date**
     - **Maximum Temperature (Kelvin)**
     - **Feels Like Temperature (Kelvin)**
     - **Humidity**
     - **Maximum Temperature (Celsius)**
     - **Feels Like Temperature (Celsius)**


## Usage

1. Access the Swagger UI for detailed API documentation: [Swagger UI](http://localhost:8080/swagger-ui.html)
2. Use the provided endpoint to get weather forecasts for various cities.

## Testing

The Weather Forecast Project uses JUnit 5 for unit testing and Mockito for mocking dependencies. Testing is an essential part of this project to ensure the reliability and correctness of the application.

## Note

Please make sure to replace the example URLs and paths with the actual deployment environment. The documentation assumes a local development setup on port 8080.
