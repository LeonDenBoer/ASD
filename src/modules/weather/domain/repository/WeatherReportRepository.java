package modules.weather.domain.repository;

import modules.weather.domain.report.WeatherReport;

public interface WeatherReportRepository {

    int provideIdentity();
    void store(WeatherReport report);

}
