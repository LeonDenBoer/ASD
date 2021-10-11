package modules.weather.application;

import modules.weather.domain.report.WeatherReport;
import modules.weather.domain.repository.WeatherReportRepository;

public class WeatherReportApplicationService {

    private WeatherReportRepository weatherReportRepository;

    public WeatherReportApplicationService(WeatherReportRepository weatherReportRepository) {
        this.weatherReportRepository = weatherReportRepository;
    }

    public void uploadWeatherReport(String details, String picture, String userId) {
        String identity = weatherReportRepository.provideIdentity();
        WeatherReport report = new WeatherReport(identity, details, picture, userId);
    }

}
