package racingcar.model;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> stringCars) {
        this.cars = stringCars.stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}
