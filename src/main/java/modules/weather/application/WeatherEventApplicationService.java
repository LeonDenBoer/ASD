package modules.weather.application;

import modules.weather.domain.event.EventAttribute;
import modules.weather.domain.event.WeatherEvent;
import modules.weather.domain.repository.WeatherEventRepository;

public class WeatherEventApplicationService {
    private WeatherEventRepository weatherEventRepository;

    public WeatherEventApplicationService(WeatherEventRepository weatherEventRepository) {
        this.weatherEventRepository = weatherEventRepository;
    }

    public void convertTemperature(int id, String newUnit, double value){
        boolean eventExits = weatherEventRepository.eventExists(id);
        if(eventExits){
            WeatherEvent weatherEvent =  weatherEventRepository.getWeatherEventById(id);
            EventAttribute eventAttribute =  weatherEvent.getEventAttribute();
            double result = eventAttribute.convertTemperature(newUnit, value);

            eventAttribute.setTemperatureScaleType(newUnit);
            eventAttribute.setValue(result);
            weatherEventRepository.updateEventAttribute(eventAttribute);
        }
    }
}

