package racingcar.domain;

import java.util.Objects;

public class TryNumber {
    private final int tryNumber;
    private final int MIN_TRYNUMBER = 1;

    public TryNumber(int tryNumber) {
        if (tryNumber < MIN_TRYNUMBER) {
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
