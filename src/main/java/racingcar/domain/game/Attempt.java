package racingcar.domain.game;

import java.util.Objects;

public class Attempt {
    private int value;
    public static final String MINUS_ATTEMPT_IS_NOT_PERMITTED = "시도 횟수는 양수로 입력하세요.";

    private Attempt(int value) {
        validate(value);
        this.value = value;
    }

    public static Attempt from(int value) {
        return new Attempt(value);
    }

    private void validate(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(MINUS_ATTEMPT_IS_NOT_PERMITTED);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Attempt attempt = (Attempt) o;
        return value == attempt.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
