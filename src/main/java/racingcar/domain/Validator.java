package racingcar.domain;

import racingcar.common.ExceptionMessage;
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

    private static void validateNameLengthLessThanEqualToFive(String name) {
        if (name.length() > Constants.NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.MORE_THAN_ALLOWED_NAME_LENGTH.getMessage());
        }
    }

    private static void validateNameNotBlank(String name) {
        if (null == name || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_NAME.getMessage());
        }
    }

    private static void validateNotEndsWithComma(String name) {
        if (name.endsWith(Constants.COMMA)) {
            throw new IllegalArgumentException(ExceptionMessage.ENDS_WITH_COMMA.getMessage());
        }
    }

    public static void validateMoveCountNaturalNumber(String number) {
        try {
            if (Integer.parseInt(number) < 0) {
                throw new IllegalArgumentException(ExceptionMessage.NEGATIVE_NUMBER.getMessage());
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER.getMessage());
        }
    }

}
