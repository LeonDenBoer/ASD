package hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.event;

import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.report.WeatherReport;

import java.util.ArrayList;

public class WeatherEvent {

    private long id;
    private String createdAt;
    private String latestUpdate;
    private String type;
    private ArrayList<WeatherReport> reports;

    public WeatherEvent() {
        calculateCurrentWeather();
    }

    private void calculateCurrentWeather() {
    }

    public void updateLatestReport(WeatherReport weatherReport) {
    }

}
