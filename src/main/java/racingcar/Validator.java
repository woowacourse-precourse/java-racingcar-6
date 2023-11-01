package racingcar;

import static racingcar.MESSAGE.VALID_COUNT;
import static racingcar.MESSAGE.VALID_LENGTH;

public class Validator {
    public static void validateInput(String[] cars, int trys) {
        for (String car: cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException(VALID_LENGTH.getMessage());
            }
        }

        if (trys <= 0) {
            throw new IllegalArgumentException(VALID_COUNT.getMessage());
        }
    }
}
