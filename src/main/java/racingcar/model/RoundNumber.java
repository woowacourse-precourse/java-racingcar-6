package racingcar.model;

import racingcar.constant.ExceptionMessage;

public class RoundNumber {
    private int number;

    public RoundNumber(String roundString) {
        parseInt(roundString);
        validatePositiveNumber();
    }

    public int getNumber() {
        return number;
    }

    private void parseInt(String roundString) {
        try {
            number = Integer.parseInt(roundString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.ROUND_NUMBER_MUST_BE_NUMBER);
        }
    }

    private void validatePositiveNumber() {
        if (number <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.ROUND_NUMBER_MUST_POSITIVE);
        }
    }
}
