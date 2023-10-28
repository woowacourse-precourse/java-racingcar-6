package racingcar.model;

import java.util.List;
import racingcar.constants.ExceptionMessage;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    private void validateCars(final List<Car> cars) {
        validateDuplicateName(cars);
    }

    private void validateDuplicateName(final List<Car> cars) {
        if (hasDuplicateName(cars)) {
            ExceptionMessage.NOT_INPUT_CARS_DUPLICATE.throwException();
        }
    }

    private boolean hasDuplicateName(final List<Car> cars) {
        return cars.stream().distinct().count() != cars.size();
    }

}
