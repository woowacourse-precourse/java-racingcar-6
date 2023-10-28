package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<String> inputCarList) {
        this.cars = new ArrayList<>();
        for (String carName : inputCarList) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> getAllCars() {
        return Collections.unmodifiableList(cars);
    }
}