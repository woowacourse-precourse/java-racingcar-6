package racingcar.exception;

import static racingcar.util.Constants.BLANK;
import static racingcar.util.Constants.NULL;

import java.util.Objects;
import racingcar.message.ErrorMessages;

public class CustomException {
    public static void blankValidator(String name) {
        if (name.contains(BLANK))  {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME_BLANK.getMessage());
        }
    }
    public static void nullValidator(String name) {
        if(Objects.equals(name, NULL)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME.getMessage());
        }
    }
    public static void MaxLengthValidator(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }
}
