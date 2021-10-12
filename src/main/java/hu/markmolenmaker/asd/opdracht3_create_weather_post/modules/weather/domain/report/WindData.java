package hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.report;

import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.WindDirection;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Map;

@Entity
public class WindData {

    @Id
    private String jpaId;

    private double windSpeed;
    private WindDirection direction;

    public WindData(Map<String, Object> details) {
        this.windSpeed = (double) details.get("windSpeed");
        this.direction = WindDirection.valueOf(String.valueOf(details.get("windDirection")));
    }

    public WindData() {

    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public WindDirection getDirection() {
        return direction;
    }
}
