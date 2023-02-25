package org.example.api;

import org.example.response.WeatherResponse;
import org.example.service.WeatherService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@RestController
@RequestMapping("api/weather")
@Validated
public class WeatherController {
    private final WeatherService weatherService;
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("current-day/country/{countryName}/city/{cityName}")
    public ResponseEntity<WeatherResponse> currentDay(@PathVariable("countryName") String countryName,
                                                      @PathVariable("cityName") String cityName){
        return weatherService.currentDay(countryName, cityName);
    }

    @GetMapping("current-week/country/{countryName}/city/{cityName}")
    public ResponseEntity<WeatherResponse> currentWeek(@PathVariable("countryName") String countryName,
                                                      @PathVariable("cityName") String cityName){
        return weatherService.currentWeek(countryName, cityName);
    }

    @GetMapping("current-month/country/{countryName}/city/{cityName}")
    public ResponseEntity<WeatherResponse> currentMonth(@PathVariable("countryName") String countryName,
                                                       @PathVariable("cityName") String cityName){
        return weatherService.currentMonth(countryName, cityName);
    }

    @GetMapping("custom-date-range/start-date/{startDate}/end-date/{endDate}/country/{countryName}/city/{cityName}")
    public ResponseEntity<WeatherResponse> customDateRange(@PathVariable("startDate")
                                                               @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate startDate,
                                                  @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate endDate,
                                                  @PathVariable("countryName") String countryName,
                                                  @PathVariable("cityName") String cityName){
        return weatherService.customDateRange(startDate, endDate, countryName, cityName);
    }
}
