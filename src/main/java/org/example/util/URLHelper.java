package org.example.util;

import java.time.LocalDate;

public final class URLHelper {
    public static String countryName(String countryName){
        return "country=" + countryName + ",";
    }
    public static String cityName(String cityName){
        return "city=" + cityName;
    }
    public static String startDate(LocalDate startDate){
        return "&dt=" + startDate;
    }
    public static String endDate(LocalDate startDate){
        return "&end_dt=" + startDate;
    }

}
