package hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.repository;

import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.event.WeatherEvent;
import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.report.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherEventRepository extends JpaRepository<WeatherEvent, Long> {

    WeatherEvent matchToWeatherEvent(Location location, String dateTime);
    void store(WeatherEvent event);

}
