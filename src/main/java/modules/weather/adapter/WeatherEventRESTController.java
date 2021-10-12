package modules.weather.adapter;

import modules.weather.application.WeatherEventApplicationService;

public class WeatherEventRESTController {

    private WeatherEventApplicationService weatherEventApplicationService;

    public WeatherEventRESTController(WeatherEventApplicationService weatherEventApplicationService) {
        this.weatherEventApplicationService = weatherEventApplicationService;
    }

    public void  convertTemperature(int id, String newUnit, double value) {
        weatherEventApplicationService.convertTemperature(id, newUnit, value);
    }
}
