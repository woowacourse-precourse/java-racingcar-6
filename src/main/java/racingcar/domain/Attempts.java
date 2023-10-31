package racingcar.domain;

public class Attempts {
    private Integer attempts;

    public Attempts(Integer attempts) {
        validate(attempts);
        this.attempts = attempts;
    }

    public boolean isNotZero() {
        return attempts != 0;
    }

    public void minusAttempts() {
        attempts -= 1;
    }

    private void validate(Integer attempts) {
        if (isZeroOrNegative(attempts)) {
            throw new IllegalArgumentException("올바르지 않은 횟수입니다.");
        }
    }

    private boolean isZeroOrNegative(int number) {
        return number <= 0;
    }
}
