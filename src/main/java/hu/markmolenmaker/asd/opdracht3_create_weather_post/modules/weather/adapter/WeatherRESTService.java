package hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.adapter;

import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.domain.event.WeatherEvent;

// @TODO: Rest annotation for outgoing?
public class WeatherRESTService {

    public void provideUpdate(long userId, WeatherEvent event) {
        System.out.printf("Sending update to user: %s, Current weather: %s%n", userId, event); // Provides an update to an external service.
    }

}
