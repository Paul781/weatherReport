package weather;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * @author msun2
 */

@Service
@Slf4j

public class weatherService {


    public weatherEntity getWeatherForCity(String city) {

        weatherEntity entity =  new weatherEntity();
        DateFormat dateFormat = new SimpleDateFormat("EEEEE hh:mm a");
        String currentTime = dateFormat.format(new Date());
        try {
            YahooWeatherService service = new YahooWeatherService();
            List<Channel> channels = service.getForecastForLocation(city, DegreeUnit.CELSIUS).first(1);

            entity.setCity(city);
            entity.setTemperature(channels.get(0).getItem().getForecasts().get(0).getHigh()+DegreeUnit.CELSIUS.toString());
            entity.setUpdateTme(currentTime);
            entity.setWeather(channels.get(0).getItem().getForecasts().get(0).getText());
            entity.setWind(channels.get(0).getWind().getSpeed().intValue()+"km/h");


        } catch (Exception e) {
            log.error("Error happened:",e);
        }

        return entity;
    }


}
