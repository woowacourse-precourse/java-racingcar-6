package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.exception.NonNumericFormatException;
import racingcar.exception.NonPositiveIntException;

public class Converter {

    private static final int ZERO = 0;
    private static final String NUMERIC_PATTERN = "\\d+";
    private static final String COMMA = ",";

    public static List<String> convertCommaSeparatedStringToList(final String input) {
        return Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .toList();
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

    private static void validatePositiveInt(final int value) {
        if (value <= ZERO) {
            throw new NonPositiveIntException();
        }
    }

    private static void validateInputIsNumeric(final String input) {
        if (!isNumeric(input)) {
            throw new NonNumericFormatException();
        }
    }

    private static boolean isNumeric(final String input) {
        return input.matches(NUMERIC_PATTERN);
    }
}
