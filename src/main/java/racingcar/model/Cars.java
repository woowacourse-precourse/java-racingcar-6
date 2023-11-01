package racingcar.model;

import java.util.*;

public class Cars {
    private final Map<String, Integer> state = new HashMap<>();

    public static Cars generateCars(String[] carNames) {
        Cars cars = new Cars();
        for (String carName : carNames) {
            cars.addCar(carName);
        }
        return cars;
    }

    public void addCar(String carName) {
        state.put(carName, 0);
    }
}
