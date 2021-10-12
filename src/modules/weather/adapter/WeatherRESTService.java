package modules.weather.adapter;

import modules.weather.domain.event.WeatherEvent;

public class WeatherRESTService {

    public void provideUpdate(String userId, WeatherEvent event) {
        System.out.printf("Sending update to user: %s, Current weather: %s%n", userId, event); // Provides an update to an external service.
    }

}
