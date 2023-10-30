package racingcar.domain;

import java.util.List;

public class Referee {
    private final List<Car> cars;

    public Referee(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        return null;
    }

    public Car findFarthestPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("자동차 리스트가 비어있습니다."));
    }

    public List<Car> findSamePositionCar() {
        return null;
    }
}
