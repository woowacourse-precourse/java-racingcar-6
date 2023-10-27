package racingcar.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Car {
    private Map<String, Integer> movingCars;

    public Map<String, Integer> getMovingCars() {
        return movingCars;
    }

    public void inputCars(String carName){
        Map<String, Integer> collectCars = new LinkedHashMap<>();
        String[] cars = carName.split(",");
        for (String car : cars) {
            collectCars.put(car,0);
        }
        movingCars = collectCars;
    }
}
