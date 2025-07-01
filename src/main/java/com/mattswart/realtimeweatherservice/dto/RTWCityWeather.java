package com.mattswart.realtimeweatherservice.dto;

public record RTWCityWeather(String cityName, double temperature) {
    /**
     * Constructs an RTWCityWeather with the given city name and temperature.
     *
     * @param cityName    the name of the city
     * @param temperature the current temperature in Celsius
     */
    public RTWCityWeather(String cityName, double temperature) {
        this.cityName = cityName;
        this.temperature = temperature;
    }
}
