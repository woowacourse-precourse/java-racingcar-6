package racingcar.domain;

import java.util.Objects;

public class Attempts {
    private static final int MAXIMUM_ATTEMPTS = 5000;
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
        if (isBigNumber(attempts)) {
            throw new IllegalArgumentException("너무 큰 숫자입니다.");
        }
    }

    private boolean isBigNumber(Integer attempts) {
        return attempts > MAXIMUM_ATTEMPTS;
    }

    private boolean isZeroOrNegative(int number) {
        return number <= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Attempts attempts1 = (Attempts) o;
        return Objects.equals(attempts, attempts1.attempts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attempts);
    }
}
