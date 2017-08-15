package weather;


import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author msun2
 */


@RestController
public class weatherController {

    private final weatherService service;

    @Inject
    public weatherController(weatherService service) {
        this.service = service;
    }

    @GetMapping("/weather")
    public weatherEntity getWeatherForCity(@RequestParam(value="city", defaultValue="Melbourne") String name) {
        return service.getWeatherForCity(name);
    }

}
