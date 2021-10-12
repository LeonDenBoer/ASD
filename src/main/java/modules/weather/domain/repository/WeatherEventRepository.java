package modules.weather.domain.repository;

import modules.weather.domain.event.EventAttribute;
import modules.weather.domain.event.WeatherEvent;

public interface WeatherEventRepository {
    boolean eventExists(int id);
    WeatherEvent getWeatherEventById(int id);
    EventAttribute updateEventAttribute(EventAttribute eventAttribute);
}
