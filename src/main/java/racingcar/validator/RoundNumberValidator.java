package racingcar.validator;

import racingcar.constant.Constants;

public class RoundNumberValidator {
    private String roundNumber;

    public RoundNumberValidator(String roundNumber) {
        this.roundNumber = roundNumber;
        validate();
    }

    private void validate() {
        isEmpty();
        isNumeric();
    }

    private void isEmpty() {
        if (roundNumber.isEmpty()) {
            throw new IllegalArgumentException(Constants.ROUND_NUMBER_EMPTY_ERROR);
        }
    }

    private void isNumeric() {
        if (!roundNumber.matches(Constants.VALID_NUMBER)) {
            throw new IllegalArgumentException(Constants.ROUND_NUMBER_INVALID_ERROR);
        }
    }
}
