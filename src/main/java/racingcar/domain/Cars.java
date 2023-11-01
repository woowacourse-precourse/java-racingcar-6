package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.ExceptionMessage;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars create(List<Car> cars) {
        validateDuplicateCarName(cars);
        return new Cars(cars);
    }

    public static void validateDuplicateCarName(List<Car> cars) {
        int distinctCarSize = (int) cars.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (cars.size() != distinctCarSize) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_DUPLICATE);
        }
    }

    public void move() {
        cars.forEach(Car::tryMove);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinnerCars() {
        Car maxPositionCar = getMaxPositionCar();
        return getEqualMaxPositionCars(maxPositionCar);
    }

    private Car getMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElse(cars.get(0));
    }

    private List<Car> getEqualMaxPositionCars(Car maxPositionCar) {
        return cars.stream()
                .filter(car -> car.isEqualPosition(maxPositionCar))
                .collect(Collectors.toList());
    }
}
