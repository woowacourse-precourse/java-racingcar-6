package racingcar.utils;

import java.util.regex.Pattern;

public class AttemptCountsInputValidator {

    private static final Pattern NUMERIC_REGEX = Pattern.compile("^(0|[-]?[1-9]\\d*)$");

    public static void validate(String target) {
        validateNumeric(target);
        validateIntegerRange(target);
        validateRange(target);
    }

    private static void validateNumeric(String target) {
        if (!NUMERIC_REGEX.matcher(target).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMERIC.getError());
        }
    }

    private static void validateIntegerRange(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_INTEGER_RANGE.getError());
        }
    }

    private static void validateRange(String target) {
        int attemptCounts = Integer.parseInt(target);
        if (attemptCounts < 1) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE.getError());
        }
    }
}
