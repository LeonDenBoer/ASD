package hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.application;

import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.adapter.TranslationService;
import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.event.WeatherEvent;
import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.report.WeatherReport;
import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.repository.WeatherEventRepository;
import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.repository.WeatherReportRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
@Service
public class WeatherApplicationService {

    private TranslationService translationService = new TranslationService();

    private final WeatherReportRepository weatherReportRepository;
    private final WeatherEventRepository weatherEventRepository;

    public WeatherApplicationService(WeatherReportRepository weatherReportRepository, WeatherEventRepository weatherEventRepository) {
        this.weatherReportRepository = weatherReportRepository;
        this.weatherEventRepository = weatherEventRepository;
    }

    public void uploadWeatherReport(long userId, String picture, Map<String, Object> details) {
        long identity = weatherReportRepository.provideIdentity();
        WeatherReport report = new WeatherReport(identity, userId, picture, details);
        WeatherEvent event = report.getWeatherEvent();

        weatherReportRepository.store(report);
        weatherEventRepository.store(event);
    }

    public WeatherReport findWeatherReport(long id, String userId) {
        if(translationService.validateUserRole(userId)){
            return weatherReportRepository.getWeatherReport(id);
        }

        return null;
    }
}
