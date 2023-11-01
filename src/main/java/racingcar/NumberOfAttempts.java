package racingcar;

import static racingcar.constant.ErrorMessage.NUMBER_OF_ATTEMPTS_IS_NOT_NUMBER;
import static racingcar.constant.ErrorMessage.NUMBER_OF_ATTEMPTS_IS_ZERO_OR_LESS;

public class NumberOfAttempts {

    private static final Integer MINIMUM_NUMBER_OF_ATTEMPTS = 1;

    private final int numberOfAttempts;

    public NumberOfAttempts(String numberOfAttemptsBeforeConverting) {
        Integer numberOfAttempts = convertInputToInteger(numberOfAttemptsBeforeConverting);
        validateNumberOfAttemptsIsOneOrLess(numberOfAttempts);
        this.numberOfAttempts = numberOfAttempts;
    }

    private void validateNumberOfAttemptsIsOneOrLess(Integer numberOfAttempts) {
        if (numberOfAttempts < MINIMUM_NUMBER_OF_ATTEMPTS) {
            throw new IllegalArgumentException(NUMBER_OF_ATTEMPTS_IS_ZERO_OR_LESS);
        }
    }

    private int convertInputToInteger(String input) {
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
