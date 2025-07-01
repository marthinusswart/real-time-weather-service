package com.mattswart.realtimeweatherservice.controller;

import com.mattswart.realtimeweatherservice.dto.RTWCityWeather;
import com.mattswart.realtimeweatherservice.dto.RTWStatus;
import com.mattswart.realtimeweatherservice.service.RealTimeWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for the Real-Time Weather Service.
 * <p>
 * Provides endpoints for health checks and weather-related operations.
 * </p>
 *
 * <p>
 * Base path: /real_time_weather_service/v1
 * </p>
 *
 * @author Matt Swart
 */
@RestController
@RequestMapping("/real_time_weather_service/v1")
public class RealTimeWeatherServiceController {
    @Value("${openweathermap.OPEN_WEATHER_MAP_API_KEY}")
    private String openWeatherMapApiKey;

    @Value("${openweathermap.OPEN_WEATHER_MAP_API_URL}")
    private String openWeatherMapApiUrl;

    @Autowired
    private RealTimeWeatherService realTimeWeatherService;

    @GetMapping("/health")
    public RTWStatus healthCheck() {
        return new RTWStatus("OK", "Real-Time Weather Service is running!");
    }

    /**
     * Endpoint to get the current weather by city name.
     *
     * @param cityName the name of the city for which to retrieve the weather
     * @return RTWCityWeather containing the current weather data for the specified city
     */
    @GetMapping("/weatherByCity/{cityName}")
    public RTWCityWeather getCurrentWeatherByCity(@PathVariable String cityName) {
        // Call the service to get the current weather by city name
        RTWCityWeather result = realTimeWeatherService.getCurrentWeatherByCity(cityName);
        return result;
    }
}
