package com.mattswart.realtimeweatherservice.service;

import com.mattswart.realtimeweatherservice.client.GeocodingApiClient;
import com.mattswart.realtimeweatherservice.dto.GeoCityDetails;
import com.mattswart.realtimeweatherservice.dto.RTWCityWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealTimeWeatherService {
    // This class will contain methods to interact with the OpenWeatherMap API
    // and provide real-time weather data.

    @Autowired
    private GeocodingApiClient geocodingApiClient;

    // Example method to get current weather by city name
    public RTWCityWeather getCurrentWeatherByCity(String cityName, String countryCode) {
        GeoCityDetails cityDetails = geocodingApiClient.getCityDetails(cityName, countryCode);
        System.out.println(String.format("City Details: %s, %s, %f, %f",
                cityDetails.name(), cityDetails.country(), cityDetails.lat(), cityDetails.lon()));
        RTWCityWeather cityWeather = new RTWCityWeather(cityName, countryCode, 0.0);
        return cityWeather;
    }

    // Additional methods for other functionalities can be added here
}
