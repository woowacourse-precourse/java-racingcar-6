package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int MAX_NAME_SIZE = 5;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateNameSize(cars);
        validateDuplicatedName(cars);
        this.cars = cars;
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
