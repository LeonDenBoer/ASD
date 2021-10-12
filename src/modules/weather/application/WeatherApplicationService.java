package modules.weather.application;

import modules.weather.domain.event.WeatherEvent;
import modules.weather.domain.report.WeatherReport;
import modules.weather.domain.repository.WeatherEventRepository;
import modules.weather.domain.repository.WeatherReportRepository;

public class WeatherApplicationService {

    private final WeatherReportRepository weatherReportRepository;
    private final WeatherEventRepository weatherEventRepository;

    public WeatherApplicationService(WeatherReportRepository weatherReportRepository, WeatherEventRepository weatherEventRepository) {
        this.weatherReportRepository = weatherReportRepository;
        this.weatherEventRepository = weatherEventRepository;
    }

    public void uploadWeatherReport(String details, String picture, String userId) {
        int identity = weatherReportRepository.provideIdentity();
        WeatherReport report = new WeatherReport(identity, details, picture, userId);
        WeatherEvent event = report.getWeatherEvent();

        weatherReportRepository.store(report);
        weatherEventRepository.store(event);
    }

}
