package racingcar.validation;

import static racingcar.configuration.InputFormatConfig.MAX_LENGTH_OF_CAR_NAME;
import static racingcar.constant.ErrorMessage.CAR_NAME_LENGTH_EXCESS_EXCEPTION;

public class InputFormatValidator {

    public static void validateLengthOfName(String name) {
        if (name.length() <= MAX_LENGTH_OF_CAR_NAME) {
            return;
        }

        throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCESS_EXCEPTION);
    }

}
