package racingcar.domain;

import racingcar.ExceptionMessage;
import racingcar.common.Constants;

public class Validator {

    public static void validateInputNames(String inputNames) {
        String[] names = inputNames.split(Constants.COMMA);
        for (String name : names) {
            validateName(name);
        }
    }

    private static void validateName(String name) {
        validateNameLengthLessThanEqualToFive(name);
        validateNameNotBlank(name);
        validateNotEndsWithComma(name);
    }

    public static void validateNameLengthLessThanEqualToFive(String name) {
        if (name.length() > Constants.NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.MORE_THAN_ALLOWED_NAME_LENGTH.getMessage());
        }
    }

    public static void validateNameNotBlank(String name) {
        if (null == name || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_NAME.getMessage());
        }
    }

    public static void validateNotEndsWithComma(String name) {
        if (name.endsWith(Constants.COMMA)) {
            throw new IllegalArgumentException(ExceptionMessage.ENDS_WITH_COMMA.getMessage());
        }
    }

    public static void validateMoveCountNumber(String number) {

    }
}
