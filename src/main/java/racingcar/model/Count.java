package racingcar.model;

import java.util.Objects;

public final class Count {
    private final int count;

    private Count(int count) {
        this.count = count;
    }

    public static Count of(int count) {
        return new Count(count);
    }

    public Count countUp() {
        return new Count(count + 1);
    }

    public boolean isEnd(TryNumber tryNumber) {
        return TryNumber.of(count).equals(tryNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count1 = (Count) o;
        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

}
