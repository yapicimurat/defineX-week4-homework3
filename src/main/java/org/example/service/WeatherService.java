package org.example.service;

import org.example.constant.API;
import org.example.exception.ResponseErrorException;
import org.example.response.WeatherResponse;
import org.example.util.URLHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class WeatherService {
    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<WeatherResponse> currentDay(String countryName, String cityName){
        final String URL = API.BASE + URLHelper.countryName(countryName) + URLHelper.cityName(cityName)
                + URLHelper.startDate(LocalDate.now());
        return request(URL);
    }

    public ResponseEntity<WeatherResponse> currentWeek(String countryName, String cityName){
        final String URL = API.BASE + URLHelper.countryName(countryName) + URLHelper.cityName(cityName)
                + URLHelper.startDate(LocalDate.now().minusDays(7)) + URLHelper.endDate(LocalDate.now());
        return request(URL);
    }

    public ResponseEntity<WeatherResponse> currentMonth(String countryName, String cityName){
        final String URL = API.BASE + URLHelper.countryName(countryName) + URLHelper.cityName(cityName)
                + URLHelper.startDate(LocalDate.now().minusDays(30)) + URLHelper.endDate(LocalDate.now());
        return request(URL);
    }

    public ResponseEntity<WeatherResponse> customDateRange(LocalDate startDate, LocalDate endDate, String countryName,
                                                           String cityName){
        final String URL = API.BASE + URLHelper.countryName(countryName) + URLHelper.cityName(cityName)
                + URLHelper.startDate(startDate) + URLHelper.endDate(endDate);
        return request(URL);
    }

    private ResponseEntity<WeatherResponse> request(String URL){
        ResponseEntity<WeatherResponse> response =
                restTemplate.getForEntity(URL, WeatherResponse.class);

        if(response.getStatusCode() != HttpStatus.OK){
            throw new ResponseErrorException("An error occurred.");
        }

        return ResponseEntity.ok(response.getBody());
    }

}
