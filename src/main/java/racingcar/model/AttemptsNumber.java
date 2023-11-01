package racingcar.model;

import static racingcar.exception.RacingCarExceptionType.INVALID_TRY_COUNT_FORMAT;
import static racingcar.exception.RacingCarExceptionType.NON_POSITIVE_TRY_COUNT;

public class AttemptsNumber {
    private static final int MINIMUM_ATTEMPTS = 1;
    private final int attemptsNumber;

    public AttemptsNumber(String attemptsNumberInput) {
        int attemptsNumber = convertStringToInt(attemptsNumberInput);
        validateAttemptsNumber(attemptsNumber);
        this.attemptsNumber = attemptsNumber;
    }

    public int getAttemptsNumber() {
        return attemptsNumber;
    }

    private int convertStringToInt(String attemptsNumberInput) {
        try {
            return Integer.parseInt(attemptsNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_FORMAT.getMessage());
        }
    }

    private void validateAttemptsNumber(int attemptsNumber) {
        if (attemptsNumber < MINIMUM_ATTEMPTS) {
            throw new IllegalArgumentException(NON_POSITIVE_TRY_COUNT.getMessage());
        }
    }
}
