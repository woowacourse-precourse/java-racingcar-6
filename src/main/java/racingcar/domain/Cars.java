package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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

    public static void validateDuplicateCarName(final List<Car> cars) {
        long distinctCarSize = Arrays.stream(cars.toArray())
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

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Cars that = (Cars) other;
        return Objects.equals(this.cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
