package hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.adapter;

import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.application.WeatherApplicationService;
import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.report.WeatherReport;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherRESTController {

    private final WeatherApplicationService weatherApplicationService;
    public WeatherRESTController(WeatherApplicationService weatherApplicationService) {
        this.weatherApplicationService = weatherApplicationService;
    }

    @PostMapping
    public void uploadWeatherReport(@RequestBody WeatherReportDTO weatherReportDTO) {
        weatherApplicationService.uploadWeatherReport(
                weatherReportDTO.details,
                weatherReportDTO.picture,
                weatherReportDTO.userId);
    }

    @GetMapping
    public WeatherReport findWeatherReport(String id, String userId) {
        return weatherApplicationService.findWeatherReport(id, userId);
    }

    private static class WeatherReportDTO {
        private String details;
        private String picture;
        private String userId;
    }
}
