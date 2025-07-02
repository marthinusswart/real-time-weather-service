package com.mattswart.realtimeweatherservice.service;

import com.mattswart.realtimeweatherservice.client.GeocodingApiClient;
import com.mattswart.realtimeweatherservice.client.OpenWeatherApiClient;
import com.mattswart.realtimeweatherservice.dto.openweather.GeoCityDetails;
import com.mattswart.realtimeweatherservice.dto.openweather.OpenWeatherResponse;
import com.mattswart.realtimeweatherservice.dto.RTWCityWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealTimeWeatherService {
    // This class will contain methods to interact with the OpenWeatherMap API
    // and provide real-time weather data.

    @Autowired
    private GeocodingApiClient geocodingApiClient;

    @Autowired
    private OpenWeatherApiClient openWeatherApiClient;

    // Example method to get current weather by city name
    public RTWCityWeather getCurrentWeatherByCity(String cityName, String countryCode) {
        GeoCityDetails cityDetails = geocodingApiClient.getCityDetails(cityName, countryCode);
        OpenWeatherResponse openWeatherDetails = openWeatherApiClient.getCityWeatherDetails(cityDetails.lat(), cityDetails.lon());
        RTWCityWeather cityWeather = new RTWCityWeather(cityName, countryCode, openWeatherDetails.main().temp());
        return cityWeather;
    }

    // Additional methods for other functionalities can be added here
}
