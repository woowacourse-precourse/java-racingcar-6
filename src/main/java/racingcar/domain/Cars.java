package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public record Cars(List<Car> cars) {
    private static final int MAX_NAME_SIZE = 5;

    public Cars {
        validateEmpty(cars);
        validateNameSize(cars);
        validateDuplicatedName(cars);
    }

    @Override
    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public Cars getWinningCars() {
        int maxDistance = findMaxDistance();

        List<Car> winningCars = cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();

        return new Cars(winningCars);
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
