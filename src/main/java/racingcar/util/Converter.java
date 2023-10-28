package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.exception.NonPositiveIntException;

public class Converter {

    private static final String POSITIVE_INTEGER_PATTERN = "^[1-9]\\d*$";
    private static final String COMMA = ",";

    public static List<String> convertCommaSeparatedStringToList(final String input) {
        return Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .toList();
    }

    public static int convertStringToPositiveInt(final String input) {
        validatePositiveInt(input);
        return parseInt(input);
    }

    private static int parseInt(final String input) {
        return Integer.parseInt(input);
    }

    private static void validatePositiveInt(final String input) {
        if (!isPositiveNumeric(input)) {
            throw new NonPositiveIntException();
        }
    }

    private static boolean isPositiveNumeric(final String input) {
        return input.matches(POSITIVE_INTEGER_PATTERN);
    }
}
