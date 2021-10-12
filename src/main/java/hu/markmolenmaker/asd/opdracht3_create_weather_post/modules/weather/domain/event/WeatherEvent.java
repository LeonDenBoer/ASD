package hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.event;

import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.report.WeatherReport;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WeatherEvent {

    @Id
    private long id;
    private String createdAt;
    private String latestUpdate;
    private String type;

    @OneToMany
    @JoinColumn
    private List<WeatherReport> reports = new ArrayList<>();

    public WeatherEvent() {
        calculateCurrentWeather();
    }

    private void calculateCurrentWeather() {
    }

    public void updateLatestReport(WeatherReport weatherReport) {
    }

}
