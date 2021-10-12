package hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.adapter;

import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.application.WeatherApplicationService;
import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.report.WeatherReport;
import org.springframework.http.HttpStatus;
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
        try {
            weatherApplicationService.uploadWeatherReport(
                    weatherReportDTO.userId,
                    weatherReportDTO.picture,
                    weatherReportDTO.details);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Upload of WeatherReport failed!");
        }
        return ResponseEntity.ok("Uploaded WeatherReport Successfully!");
    }

    @GetMapping
    public ResponseEntity<String> findWeatherReport(@RequestParam("id") String id, @RequestParam("userId")  String userId) {
        WeatherReport report = weatherApplicationService.findWeatherReport(id, userId);
        return new ResponseEntity<>(
                report.getWeatherData().getDetails(),
                HttpStatus.OK);
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
