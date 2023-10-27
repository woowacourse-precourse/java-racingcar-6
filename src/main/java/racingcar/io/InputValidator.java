package racingcar.io;

import racingcar.constant.ErrorMessage;

public class InputValidator {

    private static final String CAR_NAMES_REGEX = "^[a-zA-Z]+(,[a-zA-Z]+)*$";

    public void validateRacingCarNames(final String input) {
        if (input.isBlank() || hasInvalidDelimiterUsage(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_INPUT.toValue());
        }
    }

    private boolean hasInvalidDelimiterUsage(final String input) {
        return input.matches(CAR_NAMES_REGEX);
    }
}
