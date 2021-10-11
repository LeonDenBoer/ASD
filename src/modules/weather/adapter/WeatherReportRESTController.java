package modules.weather.adapter;

import modules.weather.application.WeatherReportApplicationService;

public class WeatherReportRESTController {

    private WeatherReportApplicationService weatherReportApplicationService;

    public WeatherReportRESTController(WeatherReportApplicationService weatherReportApplicationService) {
        this.weatherReportApplicationService = weatherReportApplicationService;
    }

    public void uploadWeatherReport(String details, String picture, String userId) {
        weatherReportApplicationService.uploadWeatherReport(details, picture, userId);
    }

}
