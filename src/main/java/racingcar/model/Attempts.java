package racingcar.model;

import racingcar.enums.ErrorMessages;
import racingcar.utils.CommonValidator;

public class Attempts {
    private final Integer number;

    public Attempts(int number) {
        this.number = number;
    }

    public Attempts(String value) {
        validateNumberOfAttemptsInput(value);
        this.number = Integer.valueOf(value);
    }

    public int getNumber() {
        return number;
    }

    private void validateNumberOfAttemptsInput(String numberOfAttempts) {
        if (numberOfAttempts == null)
            throw new IllegalArgumentException(ErrorMessages.NULL_ERROR.getMessage());
        if (numberOfAttempts.isBlank())
            throw new IllegalArgumentException(ErrorMessages.EMPTY_ERROR.getMessage());

        if (!CommonValidator.isNumeric(numberOfAttempts))
            throw new IllegalArgumentException(ErrorMessages.NUMERIC_ERROR.getMessage());
        if (!CommonValidator.isPositive(numberOfAttempts))
            throw new IllegalArgumentException(ErrorMessages.UNDER_NUMBER_ERROR.getMessage());
    }
}
