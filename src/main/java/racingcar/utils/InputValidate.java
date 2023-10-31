package racingcar.utils;

import java.util.Arrays;
import racingcar.constants.Config;
import racingcar.constants.ExceptionComments;
import racingcar.exception.CarNameDuplicateException;
import racingcar.exception.CarNameIncorrectException;
import racingcar.exception.CarNameSizeLimitExceededException;

public class InputValidate {
    public static void validateCarNames(String str) {
        checkNullAndEmpty(str);
    }

    public static void validateMovingCount(String str) {
        checkNullAndEmpty(str);
        checkNumberType(str);
    }

    public static void checkLengthCarName(String[] carNameArr) {
        for (String name : carNameArr) {
            isBlank(name);
            if (name.length() > Config.CAR_NAME_SIZE) {
                throw new CarNameSizeLimitExceededException(ExceptionComments.INPUT_VALUE_SIZE_OVER);
            }
        }
    }

    public static void checkDuplicateCarName(String[] carNameArr) {
        long carCount = Arrays.stream(carNameArr)
                .distinct()
                .count();

        if (carNameArr.length > carCount) {
            throw new CarNameDuplicateException(ExceptionComments.INPUT_CAR_NAME_DUPLICATED);
        }
    }

    private static void checkNullAndEmpty(String str) {
        isNull(str);
        isBlank(str);
    }

    private static void isNull(String str) {
        if (str == null) {
            throw new CarNameIncorrectException(ExceptionComments.INPUT_NULL_VALUE_COMMENT);
        }
    }

    private static void isBlank(String str) {
        if (str.isBlank()) {
            throw new CarNameIncorrectException(ExceptionComments.INPUT_EMPTY_VALUE_COMMENT);
        }
    }

    private static void checkNumberType(String str) {
        isDigit(str);
        isValidNumber(str);
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
