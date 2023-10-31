package racingcar.validator;

import java.util.Arrays;

public class CarInputValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void checkCarNameDuplicate(String[] cars) {
        if (Arrays.stream(cars).distinct().toArray().length != cars.length) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
