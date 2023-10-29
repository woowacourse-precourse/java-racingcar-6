package racingcar.validator;

import static java.lang.Long.parseLong;
import static racingcar.domain.ErrorConstant.*;
import static racingcar.domain.NumberConstant.*;

public class InputValidator {
    public static void validateCarNameLength(String carName) {
        if (carName.length() > MAX_RACINGCAR_NAME_LENGTH)
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
    }

    public static void validateTimesIsNumber(String line) {
        try {
            parseLong(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TIMES_NUMBER_TYPE_ERROR);
        }
    }
}
