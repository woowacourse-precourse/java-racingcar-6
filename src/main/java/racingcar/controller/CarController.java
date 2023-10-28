package racingcar.controller;

import java.util.List;
import racingcar.model.Car;


public class CarController {

    private final List<Car> cars;

    public CarController(List<Car> cars) {
        this.cars = cars;

    }

    public List<Car> getCars() {
        return cars;
    }
}
