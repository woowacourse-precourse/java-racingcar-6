package racingcar.domain;

import java.util.List;

public class Winner {

    private Cars cars;

    public Winner(Cars cars) {
        this.cars = cars;
    }

    public List<String> findWinners() {
        Car maxPositionCar = findMaxPositionCar();
        return findMaxPositionCarList(maxPositionCar);
    }

    private Car findMaxPositionCar() {
        return cars.getCars().stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private List<String> findMaxPositionCarList(Car maxPositionCar) {
        return cars.getCars().stream()
                .filter(car -> maxPositionCar.isSamePosition(car))
                .map(Car::getName)
                .toList();
    }
}
