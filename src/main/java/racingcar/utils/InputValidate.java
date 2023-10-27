package racingcar.utils;

import racingcar.constants.Config;
import racingcar.constants.ExceptionComments;
import racingcar.exception.CarNameIncorrectException;
import racingcar.exception.CarNameSizeLimitExceededException;

public class InputValidate {
    public static void checkNullAndEmpty(String str) {
        isNull(str);
        isEmpty(str);
    }

    public static void validateMovingCount(String str) {
        isNull(str);
        isEmpty(str);
        isDigit(str);
        isValidNumber(str);
    }

    public static void checkLengthCarName(String[] carNameArr) {
        for (String name : carNameArr) {
            isEmpty(name);
            if (name.length() > Config.CAR_NAME_SIZE) {
                throw new CarNameSizeLimitExceededException(ExceptionComments.INPUT_VALUE_SIZE_OVER);
            }
        }
    }

    private static void isNull(String str) {
        if (str == null) {
            throw new CarNameIncorrectException(ExceptionComments.INPUT_NULL_VALUE_COMMENT);
        }
    }

    private static void isEmpty(String str) {
        if (str.trim().isEmpty()) {
            throw new CarNameIncorrectException(ExceptionComments.INPUT_EMPTY_VALUE_COMMENT);
        }
    }

    private static void isDigit(String str) {
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ExceptionComments.INPUT_TYPE_NON_NUMBER);
            }
        }
    }

    private static void isValidNumber(String str) {
        try {
            int value = Integer.parseInt(str);
            if (value <= 0) {
                throw new IllegalArgumentException(ExceptionComments.INPUT_VALUE_INCORRECT_COMMENT);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionComments.INPUT_VALUE_INCORRECT_COMMENT);
        }
    }

}
