package modules.weather.domain.report;

import modules.weather.adapter.TranslationService;
import modules.weather.adapter.WeatherRESTService;
import modules.weather.domain.event.WeatherEvent;
import modules.weather.domain.repository.WeatherEventRepository;
import modules.weather.domain.repository.WeatherEventRepositoryImpl;

public class WeatherReport {

    private TranslationService translationService = new TranslationService();
    private WeatherEventRepository weatherEventRepository = new WeatherEventRepositoryImpl();
    private WeatherRESTService weatherRESTService = new WeatherRESTService();

    private int id;
    private String picture;
    private String recordedAt;

    private WeatherData weatherData;
    private WeatherEvent weatherEvent;

    public WeatherReport(int identity, String details, String picture, String userId) {
        this.id = identity;
        this.picture = picture;

        boolean isValid = translationService.validateUserMaySubmitReport(userId);
        if (!isValid) return;

        this.weatherData = new WeatherData(details);

        this.weatherEvent = weatherEventRepository.matchToWeatherEvent(this.weatherData.getLocation(), this.recordedAt);
        weatherEvent.updateLatestReport(this);

        weatherRESTService.provideUpdate(userId, weatherEvent);
    }

    public WeatherEvent getWeatherEvent() {
        return this.weatherEvent;
    }

}
