package weather;

/**
 * @author msun2
 */

import lombok.Data;

@Data
public class weatherEntity {

    private String city;
    private String updateTme;
    private String weather;
    private String temperature;
    private String wind;

}
