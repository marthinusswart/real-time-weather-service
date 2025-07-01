package com.mattswart.realtimeweatherservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record GeoCityDetails(String name,
                             @JsonProperty("local_names")
                             Map<String, String> localNames,
                             double lat,
                             double lon,
                             String country,
                             String state) {}
