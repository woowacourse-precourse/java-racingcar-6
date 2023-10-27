package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public String getWinner() {
        return cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}
