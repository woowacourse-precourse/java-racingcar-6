package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    private void validateCars(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("경주에 참여할 자동차는 최소 1대 이상이어야 합니다.");
        }
    }

    public void makeMoveOrStop(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.moveOrStop(numberGenerator.generate());
        }
    }

    public List<Car> findMostMovedCars() {
        return findMostMovedCars(findMaxPositionCar());
    }

    private List<Car> findMostMovedCars(Car maxPositionCar) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .collect(Collectors.toList());
    }

    private Car findMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .get();
    }
}
