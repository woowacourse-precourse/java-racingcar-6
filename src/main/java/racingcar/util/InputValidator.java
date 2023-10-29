package racingcar.util;

import java.util.List;

import static racingcar.constant.NumberConstant.MAX_NAME_LENGTH;
import static racingcar.constant.NumberConstant.MIN_ATTEMPT_NUMBER;
import static racingcar.constant.NumberConstant.MIN_NAME_LENGTH;
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
            if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(INVALID_NAME_LENGTH_EXCEPTION_MESSAGE);
            }
        }
    }

    private static boolean isNotNumber(String number) {
        return !number.matches(DIGIT);
    }

    private static boolean isInvalidRange(String number) {
        return Integer.parseInt(number) < MIN_ATTEMPT_NUMBER;
    }
}
