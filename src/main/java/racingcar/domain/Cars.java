package racingcar.domain;

import java.util.List;
import racingcar.constants.ExceptionMessage;

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
        return cars.stream().distinct().count() != cars.size();
    }

    private boolean hasMinimumCarCount(final List<Car> cars) {
        return cars.size() < 2;
    }
}
