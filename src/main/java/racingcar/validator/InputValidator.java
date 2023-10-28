package racingcar.validator;

import racingcar.exception.RacingCarException;

import static racingcar.exception.ErrorMessage.ENDS_WITH_DELIMITER;

public class InputValidator {
    private static final String DELIMITER = ",";

    private InputValidator() {
    }

    public static void validateEndsWithComma(final String input) {
        if (input.endsWith(DELIMITER)) {
            throw RacingCarException.of(ENDS_WITH_DELIMITER);
        }
    }
}
