package com.mattswart.realtimeweatherservice.dto;

public record RTWCityWeather(String cityName, String countryCode, double temperature) {
    /**
     * Constructs an RTWCityWeather with the given city name and temperature.
     *
     * @param cityName    the name of the city
     * @param countryCode he country code of the city
     * @param temperature the current temperature in Celsius
     */
    public RTWCityWeather(String cityName, String countryCode, double temperature) {
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.temperature = temperature;
    }
}
