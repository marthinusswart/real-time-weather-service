package com.mattswart.realtimeweatherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Real-Time Weather Service application.
 * <p>
 * This application utilizes the <a href="https://openweathermap.org/api">OpenWeatherMap API</a>
 * to provide real-time weather data.
 */
@SpringBootApplication
public class RealTimeWeatherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealTimeWeatherServiceApplication.class, args);
	}

}
