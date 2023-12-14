package racingcar.domain;

import racingcar.global.exception.CustomException;
import racingcar.global.exception.ErrorMessage;

public class Name {
    public static final int MIN = 1;
    public static final int MAX = 5;
    private final String name;

    public Name(String name) {
        Validator.validateRange(name.length(), MIN, MAX);
        this.name = name;
    }

    public String getValue() {
        return name;
    }

    public static class Validator {
        private static void validateRange(int length, int start, int end) {
            if (isInvalidRange(length, start, end)) {
                throw CustomException.from(ErrorMessage.INVALID_LENGTH_ERROR);
            }
        }

        private static boolean isInvalidRange(int number, int start, int end) {
            return number < start || number > end;
        }
    }
}
