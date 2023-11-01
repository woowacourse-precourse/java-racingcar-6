package racingcar.util;

import static racingcar.util.Messages.*;
import static racingcar.util.Constants.*;


public class Validation {
    public static void checkAll(String carName) {
        checkCarNameLength(carName);
        checkCarCount(carName);
    }

    private static void checkCarNameLength(String carName) {
        String[] cars = carName.split(COMMA);
        for (String car : cars) {
            if (car.isEmpty() || car.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(INVALID_CAR_NAME);
            }
        }
    }

    private static void checkCarCount(String carName) {
        String[] cars = carName.split(",");
        if (cars.length < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(INVALID_CAR_COUNT);
        }
    }
}
