package domain;

import validator.AttemptValidator;

public class AttemptCount {
    private final int attemptCount;

    public AttemptCount(String attemptString) {
        AttemptValidator.isPositiveDigit(attemptString);
        this.attemptCount = Integer.parseInt(attemptString);
    }

    public int getAttemptCount() {
        return this.attemptCount;
    }
}
