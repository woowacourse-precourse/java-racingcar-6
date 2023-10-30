package racingcar.domain;

public class AttemptCount {
    private static final int MINIMUM_ATTEMPT_COUNT = 1;
    private static final String MINIMUM_COUNT_EXCEPTION_MESSAGE =
            String.format("시도 횟수는 %d 이상이어야 합니다.", MINIMUM_ATTEMPT_COUNT);

    private int attemptCount;

    public AttemptCount(int attemptCount) {
        validate(attemptCount);
        this.attemptCount = attemptCount;
    }

    private void validate(int attemptCount) {
        if (attemptCount < MINIMUM_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(MINIMUM_COUNT_EXCEPTION_MESSAGE);
        }
    }
}
