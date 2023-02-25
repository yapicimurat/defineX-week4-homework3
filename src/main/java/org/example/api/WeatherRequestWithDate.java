package org.example.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class WeatherRequestWithDate {
    @NotBlank(message = "Country name cannot be empty")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Country name must contain only letters")
    @Size(min = 2, max = 50, message = "Country name must be between 2 and 50 characters")
    private String countryName;

    @NotBlank(message = "City name cannot be empty")
    @Pattern(regexp = "^[A-Za-z]+$", message = "City name must contain only letters")
    @Size(min = 2, max = 50, message = "City name must be between 2 and 50 characters")
    private String cityName;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
