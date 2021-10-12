package modules.weather.domain.repository;

import modules.weather.domain.event.WeatherEvent;
import modules.weather.domain.report.Location;

public interface WeatherEventRepository {

    WeatherEvent matchToWeatherEvent(Location location, String dateTime);
    void store(WeatherEvent event);

}
