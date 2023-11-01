package racingcar.validation;

import racingcar.domain.Car;

import java.util.List;

import static racingcar.configuration.InputFormatConfig.MAX_LENGTH_OF_CAR_NAME;
import static racingcar.constant.ErrorMessage.*;

public class InputFormatValidator {

    public static void validateLengthOfName(String name) {
        if (name.length() <= MAX_LENGTH_OF_CAR_NAME) {
            return;
        }

        throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCESS_EXCEPTION);
    }

    public static void validateDuplicateCarName(List<Car> cars, Car car) {
        for (Car carInCars : cars) {
            compareToCars(carInCars, car);
        }
    }

    public static void validateNumberFormat(String input) {
        if (input.matches("[1-9][0-9]*")) {
            return;
        }

        throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_EXCEPTION);
    }

    private static void compareToCars(Car carInCars, Car car) {
        if (carInCars.getName().equals(car.getName())) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_EXCEPTION + car.getName());
        }
    }

}
