package hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.report;

import hu.markmolenmaker.asd.opdracht3_create_weather_post.SpringConfiguration;
import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.adapter.TranslationService;
import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.adapter.WeatherRESTService;
import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.event.WeatherEvent;
import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.repository.WeatherEventRepository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import java.util.Map;

@Entity
public class WeatherReport {

    @Transient
    private final TranslationService translationService = new TranslationService();
    @Transient
    private final WeatherRESTService weatherRESTService = new WeatherRESTService();
    @Transient
    private final WeatherEventRepository weatherEventRepository = (WeatherEventRepository) SpringConfiguration.contextProvider().getApplicationContext().getBean("weatherEventRepository");

    @Id
    private long id;
    private String picture;
    private String recordedAt;

    @OneToOne
    private WeatherData weatherData;
    @OneToOne
    private WeatherEvent weatherEvent;

    public WeatherReport(long identity, long userId, String picture, Map<String, Object> details) {
        this.id = identity;
        this.picture = picture;
        this.recordedAt = String.valueOf(details.get("recordedAt"));

        boolean isValid = translationService.validateUserMaySubmitReport(userId);
        if (!isValid) return;

        this.weatherData = new WeatherData(details);

        this.weatherEvent = weatherEventRepository.matchToWeatherEvent(this.weatherData.getLocation(), this.recordedAt);
        weatherEvent.updateLatestReport(this);

        weatherRESTService.provideUpdate(userId, weatherEvent);
    }

    public WeatherReport() {

    }

    public WeatherEvent getWeatherEvent() {
        return this.weatherEvent;
    }

}
