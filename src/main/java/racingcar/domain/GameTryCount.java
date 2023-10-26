package racingcar.domain;

import static racingcar.exception.ExceptionMessage.GameTryCountException.CANNOT_MOVE_ANYMORE;
import static racingcar.exception.ExceptionMessage.GameTryCountException.TRY_COUNT_MUST_BE_AT_LEAST_ONE;

public class GameTryCount {
    private static final int ATTEMPT_LOWER_BOUND = 1;

    private int remainingAttempts;

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

    public void proceed() {
        if (isStillCanTry()) {
            remainingAttempts--;
            return;
        }

        throw new IllegalStateException(CANNOT_MOVE_ANYMORE.message);
    }

    public boolean isStillCanTry() {
        return remainingAttempts > 0;
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }
}
