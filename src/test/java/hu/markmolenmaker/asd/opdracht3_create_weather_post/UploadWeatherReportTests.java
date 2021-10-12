package hu.markmolenmaker.asd.opdracht3_create_weather_post;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.adapter.WeatherRESTController;
import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.application.WeatherApplicationService;
import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.repository.WeatherReportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;


@SpringBootTest
@AutoConfigureMockMvc
public class UploadWeatherReportTests {

    private final WeatherRESTController.WeatherReportDTO requestBody = new WeatherRESTController.WeatherReportDTO(
            10001000L,
            "ThisIsAPictureBlob",
            new HashMap<>(){{
                put("latitude", 51.909007769472375);
                put("longitude", 4.487149661808236);
                put("airPressure", 10.0);
                put("airHumidity", 5.0);
                put("airTemperature", 25.0);
                put("groundTemperature", 20.0);
                put("temperatureUnit", "CELSIUS");
                put("windSpeed", 2.0);
                put("windDirection", "NORTH");
                put("recordedAt", "12:00:00_01:01:2021_CEST");
            }}
    );

    @Mock
    private WeatherReportRepository weatherReportRepository;

    @Mock
    private WeatherApplicationService weatherApplicationService;

    @InjectMocks
    private WeatherRESTController weatherRESTController;

    @BeforeEach
    void setMockOutput() {
        when(weatherReportRepository.provideIdentity()).thenReturn(99998888L);
    }

    @Test
    public void testValidWeatherReportUploadReturnsStatus200() {
        ResponseEntity<String> response = weatherRESTController.uploadWeatherReport(requestBody);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void testInvalidWeatherReportUploadReturnsStatus200() {
        ResponseEntity<String> response = weatherRESTController.uploadWeatherReport(null);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

}
