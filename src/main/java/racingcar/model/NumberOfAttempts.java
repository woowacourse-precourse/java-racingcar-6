package racingcar.model;

import static racingcar.constant.ErrorMessage.NUMBER_OF_ATTEMPTS_BLANK_OR_NULL;
import static racingcar.constant.ErrorMessage.NUMBER_OF_ATTEMPTS_IS_NOT_NUMBER;
import static racingcar.constant.ErrorMessage.NUMBER_OF_ATTEMPTS_IS_ZERO_OR_LESS;

public class NumberOfAttempts {

    private static final Integer MINIMUM_NUMBER_OF_ATTEMPTS = 1;

    private final int numberOfAttempts;

    public NumberOfAttempts(final String numberOfAttemptsBeforeConverting) {
        validateNumberOfAttemptsNull(numberOfAttemptsBeforeConverting);
        Integer numberOfAttempts = convertInputToInteger(numberOfAttemptsBeforeConverting);
        validateNumberOfAttemptsIsOneOrLess(numberOfAttempts);
        this.numberOfAttempts = numberOfAttempts;
    }

    private void validateNumberOfAttemptsNull(final String numberOfAttemptsBeforeConverting) {
        if (numberOfAttemptsBeforeConverting == null || numberOfAttemptsBeforeConverting.isBlank()) {
            throw new IllegalArgumentException(NUMBER_OF_ATTEMPTS_BLANK_OR_NULL);
        }
    }

    private void validateNumberOfAttemptsIsOneOrLess(final Integer numberOfAttempts) {
        if (numberOfAttempts < MINIMUM_NUMBER_OF_ATTEMPTS) {
            throw new IllegalArgumentException(NUMBER_OF_ATTEMPTS_IS_ZERO_OR_LESS);
        }
    }

    private int convertInputToInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_OF_ATTEMPTS_IS_NOT_NUMBER);
        }
    }

    public Integer getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
