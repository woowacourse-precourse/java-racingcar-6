package racingcar.domain;

import java.util.Collections;
import java.util.List;

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
        if (hasDuplicatedName(cars)) {
            throw new IllegalArgumentException("경주에 참여하는 자동차들의 이름은 중복될 수 없습니다.");
        }
    }

    private boolean hasDuplicatedName(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .distinct()
                .count() != cars.size();
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
                .toList();
    }

    private Car findMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .get();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
