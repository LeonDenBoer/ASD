package hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.repository;

import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.event.WeatherEvent;
import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.report.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WeatherEventRepository extends JpaRepository<WeatherEvent, Long> {

    @Query(nativeQuery=true, value="unused")
    WeatherEvent matchToWeatherEvent(Location location, String dateTime);
    @Query(nativeQuery=true, value="unused")
    void store(WeatherEvent event);

}
