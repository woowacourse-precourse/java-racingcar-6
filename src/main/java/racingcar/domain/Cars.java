package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cars {
    private static final int MAX_NAME_SIZE = 5;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateEmpty(cars);
        validateNameSize(cars);
        validateDuplicatedName(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinningCars() {
        int maxDistance = findMaxDistance();

        return cars.stream().filter(car -> car.getDistance() == maxDistance)
                .toList();
    }

    private int findMaxDistance() {
        Optional<Car> findCar = cars.stream()
                .max((Car c1, Car c2)
                        -> c1.getDistance() - c2.getDistance());

        return findCar.map(Car::getDistance).orElse(0);
    }

    private void validateEmpty(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedName(List<Car> cars) {
        int distinctNameSize = getNamesNotSame(cars);

        if (distinctNameSize != cars.size()) {
            throw new IllegalArgumentException();
        }
    }

    private int getNamesNotSame(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet())
                .size();
    }

    private void validateNameSize(List<Car> cars) {
        List<Car> overNameSizeCars = cars.stream().
                filter(this::isWrongSize)
                .toList();

        if (!overNameSizeCars.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isWrongSize(Car car) {
        int size = car.getName().length();
        return (size > MAX_NAME_SIZE || size == 0);
    }
}
