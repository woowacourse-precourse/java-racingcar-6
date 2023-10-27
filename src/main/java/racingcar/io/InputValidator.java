package racingcar.io;

import racingcar.constant.ErrorMessage;

public class InputValidator {

    private static final String CAR_NAMES_REGEX = "^[ㄱ-ㅎ가-힣a-zA-Z0-9]+(,[ㄱ-ㅎ가-힣a-zA-Z0-9]+)*$";
    private static final String NUMERIC_REGEX = "^[0-9]+$";

    public void validateRacingCarNames(final String input) {
        if (input.isBlank() || hasInvalidDelimiterUsage(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_INPUT.toValue());
        }
    }

    private boolean hasInvalidDelimiterUsage(final String input) {
        return !input.matches(CAR_NAMES_REGEX);
    }

    public void validateTryCount(final String input) {
        if (hasNonNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC.toValue());
        }
    }

    private boolean hasNonNumeric(final String input) {
        return !input.matches(NUMERIC_REGEX);
    }
}
