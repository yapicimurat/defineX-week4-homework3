package org.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    //API KEY => 1a7f277eadcc4750af9114544232502
    //http://api.weatherapi.com/v1/history.json?key=1a7f277eadcc4750af9114544232502
    //&q=country=türkiye,city=bursa&dt=2023-02-20&end_dt=2023-02-25&lang=tr&aqi=no&hour=24&astro=no
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}