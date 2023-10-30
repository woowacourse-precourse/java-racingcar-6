package racingcar.utils;

import java.util.regex.Pattern;

public class AttemptCountsInputValidator {

    private static final Pattern NUMERIC_REGEX = Pattern.compile("^(0|[-]?[1-9]\\d*)$");

    public static void validate(String target) {
        validateNumeric(target);
    }

    private static void validateNumeric(String target) {
        if (!NUMERIC_REGEX.matcher(target).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMERIC.getError());
        }
    }
}
