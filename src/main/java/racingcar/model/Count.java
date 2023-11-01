package racingcar.model;

import java.util.Objects;

public class Count {
    private static final int COUNT_ZERO = 0;

    private final int count;

    public Count(final int count) {
        validateRange(count);
        this.count = count;
    }

    private void validateRange(final int count) {
        if (count < COUNT_ZERO) {
            throw new IllegalArgumentException("[Error] 시도할 횟수는 0보다 같거나 커야 합니다.");
        }
    }

    public Count down() {
        if (isCountZero()) {
            throw new IllegalArgumentException("[Error] 남은 카운트가 없습니다.");
        }
        return new Count(count - 1);
    }

    public boolean isCountZero() {
        return count == COUNT_ZERO;
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
