package racingcar.utils;

import racingcar.messages.ErrorMessage;

public class Validator {
    public static void validateRange(int num, int from, int to) throws IllegalArgumentException {
        if (!(from <= num && num <= to)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_FOR_COUNTS);
        }
    }

    public static void validateDigit(String str) throws IllegalArgumentException {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER);
        }
    }

    public static void validateRangeOfExecutions(int numOfExecutions) throws IllegalArgumentException {
        validateRange(numOfExecutions, 1, 1000);
    }

    public static void validateCarName(String name) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_NAME_LENGTH);
        }
    }
}
