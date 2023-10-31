package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.validator.CarNameValidator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private List<Car> cars;

    private Race() {

    }

    public Race(List<Car> cars) {
        CarNameValidator.validateDuplicateForList(cars);
        this.cars = cars;
    }

    public void moveEachCar() {
        cars.forEach(Car::move);
    }

    private List<Car> findWinnerCars() {
        return cars.stream()
                .filter(car -> car.isEqualOrGreaterThan(getMaxDistance()))
                .toList();
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getStatusString() {
        return cars.stream()
                .map(Car::getMovementString)
                .collect(Collectors.joining("\n")) + "\n";
    }

    public String getWinnerString() {
        return findWinnerCars().stream()
                .map(Car::getNameString)
                .collect(Collectors.joining(", "));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}