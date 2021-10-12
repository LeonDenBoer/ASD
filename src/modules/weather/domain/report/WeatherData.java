package modules.weather.domain.report;

public class WeatherData {

    private double airPressure;
    private double airHumidity;
    private WindData windData;
    private TemperatureData temperatureData;
    private Location location;

    public WeatherData(String details) {
        String wind_data = extractWindData(details);
        String temp_data = extractTempData(details);
        String loc_data = extractLocData(details);

        this.windData = new WindData(wind_data);
        this.temperatureData = new TemperatureData(temp_data);
        this.location = new Location(loc_data);
    }

    private String extractTempData(String details) {
        return "airtemperature_20.0_celsius;groundtemperature_10.0_celsius;";
    }

    private String extractWindData(String details) {
        return "windspeed_2.0_mps;winddirection_NORTH;";
    }
    private String extractLocData(String details) {
        return "0.12300302;1.29238873";
    }

    public Location getLocation() {
        return location;
    }

}
