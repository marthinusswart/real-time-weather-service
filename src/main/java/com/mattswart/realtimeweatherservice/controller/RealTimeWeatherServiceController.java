package com.mattswart.realtimeweatherservice.controller;

import com.mattswart.realtimeweatherservice.service.RealTimeWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/real_time_weather_service/v1")
public class RealTimeWeatherServiceController {
    @Value("${OPEN_WEATHER_MAP_API_KEY}")
    private String openWeatherMapApiKey;

    @Value("${OPEN_WEATHER_MAP_API_URL}")
    private String openWeatherMapApiUrl;

    @Autowired
    RealTimeWeatherService realTimeWeatherService;

    @GetMapping("/health")
    public String healthCheck() {
        return "Real-Time Weather Service is running!";
    }
}
