package hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.repository;

import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.report.WeatherReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherReportRepository extends JpaRepository<WeatherReport, Long> {

    long provideIdentity();
    
    void store(WeatherReport report);

}
