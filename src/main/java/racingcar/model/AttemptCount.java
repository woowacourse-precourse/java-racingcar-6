package racingcar.model;

public class AttemptCount {
    private static final int ZERO = 0;
    private int attemptCount;

    public AttemptCount(int attemptCount) {
        validateAttemptCount(attemptCount);
        this.attemptCount = attemptCount;
    }

    public static AttemptCount from(String attemptCount) {
        return new AttemptCount(parseInt(attemptCount));
    }

    private static int parseInt(String inputAttemptCount) {
        try {
            return Integer.parseInt(inputAttemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }
    }

    private void validateAttemptCount(int attemptCount) {
        if (attemptCount <= ZERO) {
            throw new IllegalArgumentException("시도할 횟수는 0회 초과만 가능합니다.");
        }
    }

    public boolean attemptIfPossible() {
        if (attemptCount <= ZERO) {
            return false;
        }
        attemptCount--;
        return true;
    }
}
