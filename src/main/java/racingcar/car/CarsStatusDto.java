package racingcar.car;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarsStatusDto {

    private Map<Car, String> currentCarsPositions;

    public CarsStatusDto(LinkedHashMap<Car, String> currentCarsPositions) {
        this.currentCarsPositions = currentCarsPositions;
    }

    public Map<Car, String> getCurrentCarsPositions(){
        return currentCarsPositions;
    }

    public int getCarsMaxPositionLength(){
        return currentCarsPositions.values().stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }
}
