package racingcar.model;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(List<Car> cars) {
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
