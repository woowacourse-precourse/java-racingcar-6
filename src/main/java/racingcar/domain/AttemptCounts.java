package racingcar.domain;

import static racingcar.exception.RacingCarExceptionMessage.ATTEMPT_COUNTS_NOT_IN_RANGE;
import static racingcar.exception.RacingCarExceptionMessage.ATTEMPT_COUNTS_NOT_NUMBER;

public class AttemptCounts {
    private static final int MIN_ATTEMPT_NUMBER = 1;
    private static final int MAX_ATTEMPT_NUMBER = 200_000_000;
    private int attemptCounts;

    private AttemptCounts(int attemptCounts) {
        this.attemptCounts = attemptCounts;
    }

    public static AttemptCounts from(String inputAttemptCounts) {
        int convertedAttemptCounts = convertAttemptCounts(inputAttemptCounts);
        validateAttemptCounts(convertedAttemptCounts);
        return new AttemptCounts(convertedAttemptCounts);
    }

    private static int convertAttemptCounts(String attempt) {
        int attemptNumber;
        try {
            attemptNumber = Integer.parseInt(attempt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ATTEMPT_COUNTS_NOT_NUMBER.getMessage());
        }
        return attemptNumber;
    }

    private static void validateAttemptCounts(int attemptCounts) {
        if (isInvalidAttemptCountsInRange(attemptCounts)) {
            throw new IllegalArgumentException(ATTEMPT_COUNTS_NOT_IN_RANGE.getMessage());
        }
    }

    private static boolean isInvalidAttemptCountsInRange(int attemptCounts) {
        return attemptCounts < MIN_ATTEMPT_NUMBER || MAX_ATTEMPT_NUMBER < attemptCounts;
    }

    public boolean isRemainAttemptCounts() {
        return MIN_ATTEMPT_NUMBER <= this.attemptCounts;
    }

    public void minusCounts() {
        this.attemptCounts--;
    }
}
