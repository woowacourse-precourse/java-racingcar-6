package model;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> values) {
        List<Car> cars = values.stream()
            .map(Car::from)
            .toList();

        return new Cars(cars);
    }
}
