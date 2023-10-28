package model;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final List<String> values) {
        List<Car> cars = values.stream()
            .map(Car::from)
            .toList();

        return new Cars(cars);
    }

    public void actEachCar(final Consumer<Car> action) {
        cars.forEach(action);
    }
}
