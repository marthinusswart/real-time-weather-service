package com.mattswart.realtimeweatherservice.client;

import com.mattswart.realtimeweatherservice.dto.openweather.OpenWeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class OpenWeatherApiClient {
    private String openWeatherMapApiKey;
    private String openWeatherMapGeoApiUrl;

    private final RestClient restClient;

    public OpenWeatherApiClient(RestClient.Builder builder,
                              @Value("${OPEN_WEATHER_MAP_API_KEY}") String openWeatherMapApiKey,
                              @Value("${openweathermap.OPEN_WEATHER_MAP_API_URL}") String openWeatherMapApiUrl) {
        // Initialize the RestClient with the base URL for the OpenWeatherMap Geo API
        this.restClient = builder
                .baseUrl(openWeatherMapApiUrl)
                .build();
        this.openWeatherMapApiKey = openWeatherMapApiKey;
        this.openWeatherMapGeoApiUrl = openWeatherMapApiUrl;
    }

    public OpenWeatherResponse getCityDetails(double lat, double lon) {

        OpenWeatherResponse response = restClient.get()
                .uri("/weather?lat={lat}&lon={lon}&units=metric&appid={openWeatherMapApiKey}", lat, lon, openWeatherMapApiKey)
                .retrieve()
                .body(OpenWeatherResponse.class);

       return response;
    }
}
