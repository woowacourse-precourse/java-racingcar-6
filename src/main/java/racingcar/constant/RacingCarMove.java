package racingcar.constant;

public enum RacingCarMove {

    STILL_PROCESSING(1),
    END_ATTEMPT_NUMBER(0);

    private final int value;

    RacingCarMove(final int value) {
        this.value = value;
    }

    public static boolean isProcessing(final int attemptCount) {
        return attemptCount > END_ATTEMPT_NUMBER.value;
    }

    public static int decreaseAttemptCount(int attemptCount) {
        attemptCount -= STILL_PROCESSING.value;
        return attemptCount;
    }
}
