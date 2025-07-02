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
                                @Value("${openweathermap.OPEN_WEATHER_MAP_API_URL}") String openWeatherMapApiUrl,
                                @Value("${mockopenweathermap.OPEN_WEATHER_GEO_API_URL}") String mockOpenWeatherMapGeoApiUrl,
                                @Value("${runtime.apimode}") String apiMode) {
        // Initialize the RestClient with the base URL for the OpenWeatherMap Geo API

        String apiUrl = openWeatherMapApiUrl;

        if (apiMode.equalsIgnoreCase("mock")) {
            apiUrl = mockOpenWeatherMapGeoApiUrl;
        }

        this.restClient = builder
                .baseUrl(apiUrl)
                .build();
        this.openWeatherMapApiKey = openWeatherMapApiKey;
        this.openWeatherMapGeoApiUrl = apiUrl;
    }

    public OpenWeatherResponse getCityWeatherDetails(double lat, double lon) {

        OpenWeatherResponse response = restClient.get()
                .uri("/weather?lat={lat}&lon={lon}&units=metric&appid={openWeatherMapApiKey}", lat, lon, openWeatherMapApiKey)
                .retrieve()
                .body(OpenWeatherResponse.class);

        return response;
    }
}
