package racingcar.util;

public final class InputValidator {
    private static final String CAR_NAMES_REGEX = "^(\\w+,)+\\w+$";
    private static final String NUMERIC_REGEX = "\\d+";

    public void validateInputFormat(String input) {
        if (!input.matches(CAR_NAMES_REGEX)) {
            throw new IllegalArgumentException(Err.INVALID_CAR_NAMES_FORMAT.getMessage());
        }
    }

    public void validateNonEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(Err.NON_EMPTY_STRING.getMessage());
        }
    }

    public void validateNumericString(String input) {
        if (!input.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException(Err.NUMERIC_STRING_ONLY.getMessage());
        }
    }
}
