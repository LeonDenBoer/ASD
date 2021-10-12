package hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.adapter;

import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.application.WeatherApplicationService;
import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.report.WeatherReport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/weather")
public class WeatherRESTController {

    private final WeatherApplicationService weatherApplicationService;
    public WeatherRESTController(WeatherApplicationService weatherApplicationService) {
        this.weatherApplicationService = weatherApplicationService;
    }

    @PostMapping
    public ResponseEntity<String> uploadWeatherReport(@RequestBody WeatherReportDTO weatherReportDTO) {
        weatherApplicationService.uploadWeatherReport(
                weatherReportDTO.userId,
                weatherReportDTO.picture,
                weatherReportDTO.details);
        return ResponseEntity.ok("Uploaded WeatherReport Successfully");
    }

    @GetMapping
    public WeatherReport findWeatherReport(String id, String userId) {
        return weatherApplicationService.findWeatherReport(id, userId);
    }

    public static class WeatherReportDTO {
        private final long userId;
        private final String picture;
        private final Map<String, Object> details;

        public WeatherReportDTO(long userId, String picture, Map<String, Object> details) {
            this.userId = userId;
            this.picture = picture;
            this.details = details;
        }
    }

}
