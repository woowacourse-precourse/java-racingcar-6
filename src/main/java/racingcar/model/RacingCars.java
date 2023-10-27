package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    private List<Car> cars;

    public RacingCars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getAllCars() {
        return Collections.unmodifiableList(cars);
    }
}
