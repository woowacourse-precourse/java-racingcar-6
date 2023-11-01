package racingcar.validator;

import racingcar.constant.ErrorMessage;
import racingcar.exception.RacingCarException;

public class InputNumberValidator {
    private static final Integer NEGATIVE_STANDARD = 0;

    public static void validateInputNumber(Integer inputNumber) {
        if (isNegative(inputNumber)) {
            throw new RacingCarException(ErrorMessage.NEGATIVE_VALUE);
        }
    }

    private static boolean isNegative(Integer inputNumber) {
        return inputNumber <= NEGATIVE_STANDARD;
    }
}
