package racingcar.utils;

import org.junit.platform.commons.util.StringUtils;

public class Validator {

    private static final String BLANK_OR_EMPTY = "[ERROR] 공백혹은 빈값이 아닌 값을 입력해주세요.";
    private static final String NOT_INTEGER = "[ERROR] 정수값만 입력해주세요.";
    private static final String NOT_POSITIVE_INTEGER = "[ERROR] 양의 정수값만 입력해주세요.";

    public static void validateIsBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(BLANK_OR_EMPTY);
        }
    }

    public static void validateIsInteger(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    public static void isPositiveInteger(String input) {
        int parseIntResult = Integer.parseInt(input);
        if (parseIntResult < 1) {
            throw new IllegalArgumentException(NOT_POSITIVE_INTEGER);
        }
    }
}