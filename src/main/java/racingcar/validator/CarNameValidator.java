package racingcar.validator;

import static racingcar.constant.Constants.BLANK;
import static racingcar.constant.Constants.EXCEPTION_NAME_END_BLACK;
import static racingcar.constant.Constants.EXCEPTION_NAME_LENGTH;
import static racingcar.constant.Constants.EXCEPTION_NAME_START_BLACK;
import static racingcar.constant.Constants.NAME_MAX_LENGTH;

public class CarNameValidator {

    public static void validate(String carName) {
        checkNameLength(carName);
        checkNameBlankStart(carName);
        checkNameBlankEnd(carName);
    }

    private static void checkNameLength(String carName) {
        if (carName.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_NAME_LENGTH);
        }
    }

    private static void checkNameBlankStart(String carName) {
        if (carName.charAt(0) == BLANK) {
            throw new IllegalArgumentException(EXCEPTION_NAME_START_BLACK);
        }
    }

    private static void checkNameBlankEnd(String carName) {
        if (carName.charAt(carName.length() - 1) == BLANK) {
            throw new IllegalArgumentException(EXCEPTION_NAME_END_BLACK);
        }
    }
}
