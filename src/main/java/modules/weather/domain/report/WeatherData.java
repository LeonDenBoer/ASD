package modules.weather.domain.report;

public class WeatherData {

    public WeatherData() {

    }

    public static WeatherData parseDetails(String details) {

        WeatherData weatherData = new WeatherData();

        String wind, temp = extractData(details);

        return weatherData;

    }

    private static String extractData(String data) {
        return "";
    }

}
