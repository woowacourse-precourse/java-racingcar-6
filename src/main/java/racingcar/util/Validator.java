package racingcar.util;

import static racingcar.util.exception.ErrorMessage.*;

import racingcar.util.exception.RacingCarException;

public class Validator {
    public static void validateEmpty(String userInput) {
        if (isEmpty(userInput)) {
            throw RacingCarException.of(EMPTY_NUMBER);
        }
    }

    private static boolean isEmpty(String userInput) {
        return userInput.isEmpty();
    }

    public static void validatePositive(String userInput) {
        if (isLessThanOne(userInput)) {
            throw RacingCarException.of(LESS_THAN_ONE);
        }
    }

    private static boolean isLessThanOne(String userInput) {
        return Integer.parseInt(userInput) < 1;
    }

    public static void validateInteger(String userInput) {
        if (!isInteger(userInput)) {
            throw RacingCarException.of(NOT_INTEGER);
        }
    }

    private static boolean isInteger(String userInput) {
        return userInput.chars()
                .allMatch(Character::isDigit);
    }
}
