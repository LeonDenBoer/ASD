package hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.report;

import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.Unit;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Map;

@Entity
public class TemperatureData {

    @Id
    private String jpaId;

    private double airTemperature;
    private double groundTemperature;
    private Unit unit;

    public TemperatureData(Map<String, Object> details) {
        this.airTemperature = (double) details.get("airTemperature");
        this.groundTemperature = (double) details.get("groundTemperature");
        this.unit = Unit.valueOf(String.valueOf(details.get("temperatureUnit")));
    }

    public TemperatureData() {

    }

    public double getAirTemperature() {
        return airTemperature;
    }

    public double getGroundTemperature() {
        return groundTemperature;
    }

    public Unit getUnit() {
        return unit;
    }
}
