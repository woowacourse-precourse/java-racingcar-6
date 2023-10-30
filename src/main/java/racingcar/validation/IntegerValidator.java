package racingcar.validation;

import racingcar.util.ExceptionUtil;
import racingcar.util.IntegerUtil;

public class IntegerValidator {
    private static final String INVALID_INTEGER_MESSAGE = "정수 값이 필요합니다.";

    public static void validateInteger(Object object) {
        if (!(object instanceof Integer)) {
            ExceptionUtil.throwInvalidValueException(INVALID_INTEGER_MESSAGE);
        }
    }

    public static void validateInteger(String string) {
        if (!IntegerUtil.isInteger(string)) {
            ExceptionUtil.throwInvalidValueException(INVALID_INTEGER_MESSAGE);
        }
    }
}
