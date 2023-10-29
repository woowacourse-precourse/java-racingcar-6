package racingcar.constants;

public enum RacingCarMove {

    NEXT_POSITION(1),
    END_ATTEMPT_NUMBER(0);

    private final int value;

    RacingCarMove(int value) {
        this.value = value;
    }

    public static boolean isProcessing(int attemptCount) {
        return attemptCount > END_ATTEMPT_NUMBER.value;
    }

    public static int updateAttemptCount(int attemptCount) {
        attemptCount -= NEXT_POSITION.value;
        return attemptCount;
    }
}
