package racingcar.model;

import java.util.Map;

public class GameDto {
    private final Map<String, CarDto> cars;
    public GameDto(Map<String, CarDto> cars){
        this.cars=cars;
    }

    public Map<String,CarDto> getCars(){
        return cars;
    }
}
