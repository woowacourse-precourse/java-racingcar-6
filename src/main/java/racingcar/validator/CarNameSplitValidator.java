package racingcar.validator;

import static racingcar.constant.Constants.DOUBLE_USE_SEPARATOR;
import static racingcar.constant.Constants.EXCEPTION_BLACK_INPUT;
import static racingcar.constant.Constants.EXCEPTION_DOUBLE_USE_SEPARATOR;
import static racingcar.constant.Constants.EXCEPTION_SEPARATOR_END;
import static racingcar.constant.Constants.EXCEPTION_SEPARATOR_START;
import static racingcar.constant.Constants.NAME_SEPARATOR;

public class CarNameSplitValidator {


    public static void validate(String readLine) {
        checkEmptyInput(readLine);
        checkInvalidSeparator(readLine);
    }

    private static void checkEmptyInput(String readLine) {
        if (readLine.isBlank()) {
            throw new IllegalArgumentException(EXCEPTION_BLACK_INPUT);
        }
    }

    private static void checkInvalidSeparator(String readLine) {
        if (readLine.charAt(0) == NAME_SEPARATOR) {
            throw new IllegalArgumentException(EXCEPTION_SEPARATOR_START);
        }
        if (readLine.charAt(readLine.length() - 1) == NAME_SEPARATOR) {
            throw new IllegalArgumentException(EXCEPTION_SEPARATOR_END);
        }
        if (readLine.contains(DOUBLE_USE_SEPARATOR)) {
            throw new IllegalArgumentException(EXCEPTION_DOUBLE_USE_SEPARATOR);
        }
    }
}
