package racingcar.validator;

import java.util.regex.Pattern;
import racingcar.common.exception.ErrorMessage;

public class Validator {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");

    private Validator() {
    }

    public static void validateHasText(String input) {
        if (input == null || input.isBlank()) {
            throw ErrorMessage.BLANK_INPUT.getException();
        }
    }

    public static void validateLength(String input, int minLength, int maxLength) {
        int length = input.length();

        if (length < minLength || length > maxLength) {
            throw ErrorMessage.INVALID_LENGTH_INPUT.getException();
        }
    }

    public static void validateNumeric(String input) {
        if (NUMERIC_PATTERN.matcher(input).matches()) {
            throw ErrorMessage.INVALID_NUMERIC_INPUT.getException();
        }
    }
}
