package racingcar.domain;

import static racingcar.exception.ExceptionMessage.GameTryCountException.TRY_COUNT_MUST_BE_AT_LEAST_ONE;

public class GameTryCount {
    private static final int ATTEMPT_LOWER_BOUND = 1;

    private final int remainingAttempts;

    private GameTryCount(final int attemptCount) {
        this.remainingAttempts = attemptCount;
    }

    public static GameTryCount from(final int attemptCount) {
        validateAttemptCount(attemptCount);
        return new GameTryCount(attemptCount);
    }

    private static void validateAttemptCount(final int attemptCount) {
        if (attemptCount < ATTEMPT_LOWER_BOUND) {
            throw new IllegalArgumentException(TRY_COUNT_MUST_BE_AT_LEAST_ONE.message);
        }
    }
}
