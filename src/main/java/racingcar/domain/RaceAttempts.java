package racingcar.domain;

import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class RaceAttempts {

    public static final int MIN_ATTEMPTS = 1;
    private final int attempts;

    public RaceAttempts(int attempts) {
        validateAttemptsRange(attempts);
        this.attempts = attempts;
    }

    private void validateAttemptsRange(int attempts) {
        if (attempts < MIN_ATTEMPTS) {
            throw new InvalidInputException(ErrorMessage.INVALID_RACE_ATTEMPTS);
        }
    }

    public int getAttempts() {
        return attempts;
    }
}
