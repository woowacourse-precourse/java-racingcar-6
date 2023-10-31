package racingcar.model;

import java.util.Objects;

public final class TryNumber {
    private final int number;

    private TryNumber(int number) {
        this.number = number;
    }

    public static TryNumber of(int number) {
        return new TryNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryNumber tryNumber = (TryNumber) o;
        return number == tryNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
