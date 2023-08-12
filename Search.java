package com.skyscanner;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Search {
    @JsonProperty("city")
    private String city;

    public Search(String city) {
        this.city = city;
    }

    // Getters and setters (optional, based on needs)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonRequest = "{ \"city\": \"shaleport\" }"; // Example JSON request
    Search search = objectMapper.readValue(jsonRequest, Search.class);

    Search search = new Search("shaleport");
    String jsonResponse = objectMapper.writeValueAsString(search);