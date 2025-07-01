package com.mattswart.realtimeweatherservice.dto.openweather;

import java.util.List;

public record OpenWeatherResponse(
        Coordinates coord,
        List<Weather> weather,
        String base,
        OpenWeatherMainData main,
        int visibility,
        Wind wind,
        Rain rain,
        Clouds clouds,
        long dt,
        SystemInfo sys,
        int timezone,
        int id,
        String name,
        int cod
) {}

record Coordinates(
        double lon,
        double lat
) {}

record Weather(
        int id,
        String main,
        String description,
        String icon
) {}

record Wind(
        double speed,
        int deg,
        double gust
) {}

record Rain(
        double h1
) {}

record Clouds(
        int all
) {}

record SystemInfo(
        int type,
        int id,
        String country,
        long sunrise,
        long sunset
) {}