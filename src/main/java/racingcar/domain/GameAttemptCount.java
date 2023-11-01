package racingcar.domain;

public class GameAttemptCount {
    private static final int END_COUNT = 0;
    private int attemptCount;

    public GameAttemptCount(int attemptCount) {
        validateNumberGreaterThanZero(attemptCount);
        this.attemptCount = attemptCount;
    }

    private void validateNumberGreaterThanZero(int attemptCount) {
        if (attemptCount <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 회수는 0보다 커야합니다.");
        }
    }

    public void reduceAttemptCount() {
        attemptCount -= 1;
    }

    public boolean isEnd() {
        if (attemptCount == END_COUNT) {
            return true;
        }
        return false;
    }

}
