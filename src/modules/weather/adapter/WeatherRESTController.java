package modules.weather.adapter;

import modules.weather.application.WeatherApplicationService;

public class WeatherRESTController {

    private final WeatherApplicationService weatherApplicationService;

    public WeatherRESTController(WeatherApplicationService weatherApplicationService) {
        this.weatherApplicationService = weatherApplicationService;
    }

    public void uploadWeatherReport(String details, String picture, String userId) {
        weatherApplicationService.uploadWeatherReport(details, picture, userId);
    }

}
