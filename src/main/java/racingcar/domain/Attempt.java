package racingcar.domain;

public class Attempt {
    private final int attemptCount;

    public Attempt(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
