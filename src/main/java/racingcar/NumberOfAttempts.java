package racingcar;

import static racingcar.constant.ErrorMessage.NUMBER_OF_ATTEMPTS_IS_NOT_NUMBER;
import static racingcar.constant.ErrorMessage.NUMBER_OF_ATTEMPTS_IS_ZERO_OR_LESS;

public class NumberOfAttempts {

    private static final Integer MINIMUM_NUMBER_OF_ATTEMPTS = 1;

    private Integer numberOfAttempts;

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

    private Integer convertInputToInteger(String input) {
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_OF_ATTEMPTS_IS_NOT_NUMBER);
        }
    }

    public Integer getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
