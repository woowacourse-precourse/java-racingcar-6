package racingcar.domain;

import java.util.List;

public class Winners {

    private List<Car> winners;

    public Winners(List<Car> cars) {
        winners = findWinners(cars);
    }

    public List<Car> findWinners(List<Car> cars) {
        Car maxPositionCar = findMaxPositionCar(cars);
        return findMaxPositionCarList(maxPositionCar, cars);
    }

    private Car findMaxPositionCar(List<Car> cars) {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private List<Car> findMaxPositionCarList(Car maxPositionCar, List<Car> cars) {
        return cars.stream()
                .filter(car -> maxPositionCar.isSamePosition(car))
                .toList();
    }

    public List<Car> getWinners() {
        return winners;
    }
}
