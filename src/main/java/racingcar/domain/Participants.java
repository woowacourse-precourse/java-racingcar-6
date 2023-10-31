package racingcar.domain;

import java.util.List;
import racingcar.domain.validator.CarsValidator;

public class Participants extends CarsValidator {
    private final List<Car> cars;

    public Participants(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> race() {
        cars.forEach(Car::moveForward);

        return deepCopyFrom(cars);
    }

    private List<Car> deepCopyFrom(List<Car> cars) {
        return cars.stream()
                .map(car -> new Car(car.getName(), car.getPosition(), null))
                .toList();
    }

    public List<String> getWinners() {
        Car first = findFirst();

        return cars.stream()
                .filter(car -> isSamePosition(car, first))
                .map(Car::getName)
                .toList();
    }

    private Car findFirst() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow();
    }

    private boolean isSamePosition(Car car, Car first) {
        return car.getPosition() == first.getPosition();
    }
}
