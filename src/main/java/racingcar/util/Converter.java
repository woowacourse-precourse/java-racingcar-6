package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Converter {

    private static final int ZERO = 0;
    private static final String NON_NUMERIC_INPUT_MESSAGE = "숫자가 아닙니다.";
    private static final String POSITIVE_INT_INPUT_MESSAGE = "양의 정수가 아닙니다.";
    private static final String NUMERIC_PATTERN = "\\d+";

    public static List<String> convertCommaSeparatedStringToList(final String input) {
        return Arrays.asList(input.split(","));
    }

    public static int convertStringToPositiveInt(final String input) {
        validateInputIsNumeric(input);
        int value = parseInt(input);
        validatePositiveInt(value);
        return value;
    }

    private static int parseInt(final String input) {
        return Integer.parseInt(input);
    }

    private static void validatePositiveInt(int value) {
        if (value <= ZERO) {
            throw new IllegalArgumentException(POSITIVE_INT_INPUT_MESSAGE);
        }
    }

    private static void validateInputIsNumeric(final String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT_MESSAGE);
        }
    }

    private static boolean isNumeric(final String input) {
        return input.matches(NUMERIC_PATTERN);
    }
}
