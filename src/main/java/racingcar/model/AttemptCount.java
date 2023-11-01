package racingcar.model;

public class AttemptCount {

    private static final int MIN_ATTEMPT_COUNT = 1;

    public AttemptCount(int attemptCount) {
        validateRange(attemptCount);
    }

    private void validateRange(int attemptCount) {
        if (attemptCount < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
