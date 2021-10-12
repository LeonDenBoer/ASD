package hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.report;

import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.adapter.TranslationService;
import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.adapter.WeatherRESTService;
import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.event.WeatherEvent;

public class WeatherReport {

    private TranslationService translationService = new TranslationService();
    private WeatherRESTService weatherRESTService = new WeatherRESTService();

    private long id;
    private String picture;
    private String recordedAt;

    private WeatherData weatherData;
    private WeatherEvent weatherEvent;

    public WeatherReport(long identity, String details, String picture, String userId) {
        this.id = identity;
        this.picture = picture;

        boolean isValid = translationService.validateUserMaySubmitReport(userId);
        if (!isValid) return;

        this.weatherData = new WeatherData(details);

        //this.weatherEvent = weatherEventRepository.matchToWeatherEvent(this.weatherData.getLocation(), this.recordedAt);
        weatherEvent.updateLatestReport(this);

        weatherRESTService.provideUpdate(userId, weatherEvent);
    }

    public WeatherEvent getWeatherEvent() {
        return this.weatherEvent;
    }

}
