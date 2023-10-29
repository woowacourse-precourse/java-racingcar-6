package racingcar.io;

import racingcar.constant.ErrorMessage;

public class InputValidator {

    private static final String DOUBLE_CAR_NAMES_DELIMITER = ",,";
    private static final String CAR_NAMES_DELIMITER = ",";
    private static final String BLANK_AFTER_COMMA = ", ";
    private static final String BLANK_BEFORE_COMMA = " ,";
    private static final String BLANK = " ";
    private static final char MIN_NUMBER = '0';
    private static final char MAX_NUMBER = '9';

    public void validateRacingCarNames(final String input) {
        if (hasInvalidDelimiterUsage(input) || hasInvalidBlankUsage(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_INPUT.toValue());
        }
    }

    private boolean hasInvalidDelimiterUsage(final String input) {
        return input.startsWith(CAR_NAMES_DELIMITER)
                || input.endsWith(CAR_NAMES_DELIMITER)
                || input.contains(DOUBLE_CAR_NAMES_DELIMITER);
    }

    private boolean hasInvalidBlankUsage(final String input) {
        return input.startsWith(BLANK)
                || input.endsWith(BLANK)
                || input.contains(BLANK_AFTER_COMMA)
                || input.contains(BLANK_BEFORE_COMMA);
    }

    public void validateTryCount(final String input) {
        if (hasNonNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC.toValue());
        }
    }

    private boolean hasNonNumeric(final String input) {
        return input.chars().anyMatch(this::isNotNumeric);
    }

    private boolean isNotNumeric(final int element) {
        return MIN_NUMBER > element || element > MAX_NUMBER;
    }
}
