package racingcar.util;

import java.util.List;

import static racingcar.constant.StringConstant.DIGIT;
import static racingcar.constant.StringConstant.INVALID_ATTEMPT_NUMBER_RANGE_EXCEPTION_MESSAGE;
import static racingcar.constant.StringConstant.INVALID_NAME_LENGTH_EXCEPTION_MESSAGE;
import static racingcar.constant.StringConstant.INVALID_NUMBER_EXCEPTION_MESSAGE;

public class InputValidator {
    public static void validateCarNames(List<String> carNames) {
        checkNameLength(carNames);
    }

    public static boolean validateAttemptNumber(String input) {
        if (isNotNumber(input)) {
            throw new IllegalArgumentException(INVALID_NUMBER_EXCEPTION_MESSAGE);
        }
        if (isInvalidRange(input)) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
        return true;
    }

    private static void checkNameLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() < 1 || name.length() > 5) {
                throw new IllegalArgumentException(INVALID_NAME_LENGTH_EXCEPTION_MESSAGE);
            }
        }
    }

    private static boolean isNotNumber(String number) {
        return !number.matches(DIGIT);
    }

    private static boolean isInvalidRange(String number) {
        return Integer.parseInt(number) < 1;
    }
}
