package racingcar.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.constants.ExceptionMessage;
import racingcar.util.RandomNumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    private void validateCars(final List<Car> cars) {
        validateDuplicateName(cars);
        validateMinimunCarCount(cars);
    }

    private void validateDuplicateName(final List<Car> cars) {
        if (hasDuplicateName(cars)) {
            ExceptionMessage.NOT_INPUT_CARS_DUPLICATE.throwException();
        }
    }

    private void validateMinimunCarCount(final List<Car> cars) {
        if (hasMinimumCarCount(cars)) {
            ExceptionMessage.CARS_LESS_THAN_TWO.throwException();
        }
    }

    private boolean hasDuplicateName(final List<Car> cars) {
        Set<String> carNames = new HashSet<>();
        return cars.stream()
                .map(Car::getName)
                .anyMatch(name -> !carNames.add(name));
    }

    private boolean hasMinimumCarCount(final List<Car> cars) {
        return cars.size() < 2;
    }

    public void moveAll(RandomNumberGenerator randomNumberGenerator) {
        for (final Car car : cars) {
            final int value = randomNumberGenerator.generateRandomNumber();
            car.moveToCar(value);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
