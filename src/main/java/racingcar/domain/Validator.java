package racingcar.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import racingcar.constant.ExceptionMessage;
import racingcar.constant.GameRule;

public class Validator {
    public static void validateCarNames(String carNames) {
        checkEmpty(carNames);
        checkCommaStartOrEnd(carNames);
        checkConsecutiveCommas(carNames);
        checkWhitespace(carNames);

        String[] names = carNames.split(GameRule.DELIM);
        for (String name : names) {
            checkNameLength(name);
        }
        checkDuplicates(names);
    }

    public static void validateTryNumber(String tryNumber) {
        checkNotNumber(tryNumber);
        checkPositiveNumber(tryNumber);
    }

    private static void checkEmpty(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_ERROR);
        }
    }

    private static void checkCommaStartOrEnd(String carNames) {
        if (carNames.startsWith(GameRule.DELIM) || carNames.endsWith(GameRule.DELIM)) {
            throw new IllegalArgumentException(ExceptionMessage.COMMA_START_END_ERROR);
        }
    }

    private static void checkConsecutiveCommas(String carNames) {
        if (carNames.contains(",,")) {
            throw new IllegalArgumentException(ExceptionMessage.COMMA_CONSECUTIVE_ERROR);
        }
    }

    private static void checkWhitespace(String carNames) {
        if (carNames.contains(" ")) {
            throw new IllegalArgumentException(ExceptionMessage.WHITESPACE_ERROR);
        }
    }

    private static void checkNameLength(String name) {
        if (name.length() > GameRule.MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.LENGTH_ERROR);
        }
    }

    private static void checkDuplicates(String[] names) {
        Set<String> unique = new HashSet<>();

        if (!Arrays.stream(names)
                .allMatch(unique::add)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_ERROR);
        }
    }

    private static void checkNotNumber(String tryNumber) {
        if (tryNumber == null || !tryNumber.matches("\\d+")) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_ERROR);
        }
    }

    private static void checkPositiveNumber(String tryNumber) {
        if (Integer.parseInt(tryNumber) <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.NEGATIVE_NUMBER_ERROR);
        }
    }
}
