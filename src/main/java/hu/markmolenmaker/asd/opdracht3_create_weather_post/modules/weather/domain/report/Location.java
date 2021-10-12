package hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.report;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Map;

@Entity
public class Location {

    @Id
    private String jpaId;

    private double latitude;
    private double longitude;

    public Location(Map<String, Object> details) {
        this.latitude = (double) details.get("latitude");
        this.longitude = (double) details.get("longitude");
    }

    public Location() {

    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
