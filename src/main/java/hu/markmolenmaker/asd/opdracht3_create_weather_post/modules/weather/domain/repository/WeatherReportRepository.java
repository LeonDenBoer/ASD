package hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.repository;

import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.report.WeatherReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WeatherReportRepository extends JpaRepository<WeatherReport, Long> {

    @Query(nativeQuery=true, value="unused")
    long provideIdentity();
    @Query(nativeQuery=true, value="unused")
    void store(WeatherReport report);

    WeatherReport getWeatherReport(String id);
}
