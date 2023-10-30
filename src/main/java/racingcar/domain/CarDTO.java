package racingcar.domain;

import java.util.HashMap;

public class CarDTO {

    private HashMap<String, Integer> car = new HashMap<>();

    public CarDTO(String carName) {
        car.put(carName, 0);
    }

    public int getMovingCount(String carName) {
        return car.get(carName);
    }

}
