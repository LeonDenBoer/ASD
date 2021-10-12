package modules.weather.domain.report;

public class Location {

    private long longitude;
    private long latitude;

    public Location(String loc_data) {

    }

    public Location(long longitude, long latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

}
