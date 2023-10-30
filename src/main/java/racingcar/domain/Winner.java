package racingcar.domain;

import java.util.List;

public class Winner {

    private List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> findWinners() {
        Car maxPositionCar = findMaxPositionCar();
        return findMaxPositionCarList(maxPositionCar);
    }

    private Car findMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private List<String> findMaxPositionCarList(Car maxPositionCar) {
        return cars.stream()
                .filter(car -> maxPositionCar.isSamePosition(car))
                .map(Car::getName)
                .toList();
    }
}
