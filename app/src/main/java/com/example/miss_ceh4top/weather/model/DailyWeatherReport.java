package com.example.miss_ceh4top.weather.model;

/**
 * Created by MISS_CEH4TOP on 13.01.2017.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import android.util.Log;

public class DailyWeatherReport {

    public static final String WEATHER_TYPE_CLOUDS = "Clouds";
    public static final String WEATHER_TYPE_CLEAR = "Clear";
    public static final String WEATHER_TYPE_RAIN = "Rain";
    public static final String WEATHER_TYPE_WIND = "Wind";
    public static final String WEATHER_TYPE_SNOW = "Snow";



    private String cityName;
    private String country;
    private int currentTemp;
    private int maxTemp;
    private int minTemp;
    private String weather;
    private String formattedDate;


    public String getCityName() {
        return cityName;
    }

    public String getCountry() {
        return country;
    }

    public int getCurrentTemp() {
        return currentTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public String getWeather() {
        return weather;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public DailyWeatherReport(String cityName, String country, int currentTemp, int maxTemp, int minTemp, String weather, String rawDate) throws ParseException {
        this.cityName = cityName;
        this.country = country;
        this.currentTemp = currentTemp;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.weather = weather;
        this.formattedDate = rawDateToPretty(rawDate);
    }

    public String rawDateToPretty(String rawDate) throws ParseException {

        // 2016-12-27 18:00:00
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String curDate = dateFormat.format( new Date());
        //Log.v("Date: ","Cur date: " + dateFormat.format( new Date()));
        rawDate = rawDate.substring(0,10);

        if (rawDate.equals(curDate)) {

            SimpleDateFormat dateFormatCur = new SimpleDateFormat("MMMM dd", Locale.ENGLISH);
            return "" + dateFormatCur.format( new Date() );
        } else {
            SimpleDateFormat dateFormatCur = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date  = dateFormatCur.parse(rawDate);
            SimpleDateFormat dateFormatResult = new SimpleDateFormat("MMMM dd", Locale.ENGLISH);

            return "" + dateFormatResult.format( date );
        }

    }

}

