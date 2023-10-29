package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.exception.NonPositiveIntException;

public class Converter {

    private static final String COMMA = ",";
    private static final String POSITIVE_INTEGER_PATTERN = "^[1-9]\\d*$";
    private static final Pattern pattern = Pattern.compile(POSITIVE_INTEGER_PATTERN);

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
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
