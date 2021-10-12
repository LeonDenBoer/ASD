package modules.weather.domain.repository;

import modules.weather.domain.event.WeatherEvent;
import modules.weather.domain.report.Location;

public class WeatherEventRepositoryImpl implements WeatherEventRepository {

    @Override
    public WeatherEvent matchToWeatherEvent(Location location, String dateTime) {
        return new WeatherEvent();
    }

    @Override
    public void store(WeatherEvent event) {

    }
}
