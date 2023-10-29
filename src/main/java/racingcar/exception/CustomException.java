package racingcar.exception;

import static racingcar.util.Constants.BLANK;
import static racingcar.util.Constants.NULL;

import java.util.Objects;
import racingcar.message.ErrorMessages;

public class CustomException {
    public static void blankValidator(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME_BLANK.getMessage());
        }
    }

    public static void nullValidator(String name) {
        if (Objects.equals(name, NULL)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME.getMessage());
        }
    }

    public static void MaxLengthValidator(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }

    public static void numericValidator(String input) {

        throw new IllegalArgumentException(ErrorMessages.INVALID_NUMERIC_INPUT.getMessage());

    }
    public static void positiveValidator(int tryCount) {
        if (tryCount < 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMERIC_INPUT.getMessage());
        }
    }
}
