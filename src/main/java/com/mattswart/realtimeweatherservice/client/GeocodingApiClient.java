package com.mattswart.realtimeweatherservice.client;

import com.mattswart.realtimeweatherservice.dto.openweather.GeoCityDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class GeocodingApiClient {
    private String openWeatherMapApiKey;
    private String openWeatherMapGeoApiUrl;

    private final RestClient restClient;


    public GeocodingApiClient(RestClient.Builder builder,
                              @Value("${OPEN_WEATHER_MAP_API_KEY}") String openWeatherMapApiKey,
                              @Value("${openweathermap.OPEN_WEATHER_GEO_API_URL}") String openWeatherMapGeoApiUrl,
                              @Value("${mockopenweathermap.OPEN_WEATHER_GEO_API_URL}") String mockOpenWeatherMapGeoApiUrl,
                              @Value("${runtime.apimode}") String apiMode) {
        // Initialize the RestClient with the base URL for the OpenWeatherMap Geo API
        String apiUrl = openWeatherMapGeoApiUrl;

        if (apiMode.equalsIgnoreCase("mock")) {
            apiUrl = mockOpenWeatherMapGeoApiUrl;
        }
        this.restClient = builder
                .baseUrl(apiUrl)
                .build();
        this.openWeatherMapApiKey = openWeatherMapApiKey;
        this.openWeatherMapGeoApiUrl = apiUrl;
    }

    public GeoCityDetails getCityDetails(String cityName, String countryCode) {
        //System.out.println(String.format("the Uri: /direct?q={%s},{%s}&limit=1&appid={%s}", cityName, countryCode, openWeatherMapApiKey));
        var cities = restClient.get()
                .uri("/direct?q={cityName},{countryCode}&limit=1&appid={openWeatherMapApiKey}", cityName, countryCode, openWeatherMapApiKey)
                .retrieve()
                .body(GeoCityDetails[].class);

        if (cities != null && cities.length > 0) {
            return cities[0];
        } else
            return null;
    }


}
