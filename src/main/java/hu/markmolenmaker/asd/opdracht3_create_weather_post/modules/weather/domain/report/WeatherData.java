package hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.report;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Map;

@Entity
public class WeatherData {

    @Id
    private String jpaId;

    private double airPressure;
    private double airHumidity;
    @OneToOne
    private WindData windData;
    @OneToOne
    private TemperatureData temperatureData;
    @OneToOne
    private Location location;

    public WeatherData(Map<String, Object> details) {
        this.airPressure = (double) details.get("airPressure");
        this.airHumidity = (double) details.get("airHumidity");
        this.windData = new WindData(details);
        this.temperatureData = new TemperatureData(details);
        this.location = new Location(details);
    }

    public WeatherData() {

    }

    public Location getLocation() {
        return location;
    }

    public WindData getWindData() {
        return windData;
    }

    public TemperatureData getTemperatureData() {
        return temperatureData;
    }

    public double getAirPressure() {
        return airPressure;
    }

    public double getAirHumidity() {
        return airHumidity;
    }

}
