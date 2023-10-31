package racingcar.domain;

import java.util.Objects;

public class TryNumber {
    private final int tryNumber;

    public TryNumber(int tryNumber) {
        if (tryNumber < 1) {
            throw new IllegalArgumentException();
        }
        this.tryNumber = tryNumber;
    }

    public int getTryNumber() {
        return tryNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryNumber tryNumber1 = (TryNumber) o;
        return tryNumber == tryNumber1.tryNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryNumber);
    }
}
