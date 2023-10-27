package racingcar.service;

import java.util.Objects;

public class Count {
    private final int value;
    private static final Count INSTANCE_WITH_ZERO_VALUE = new Count(0);

    private Count(int value) {
        this.value = value;
    }
    public static Count zero() {
        return INSTANCE_WITH_ZERO_VALUE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Count count = (Count) o;
        return value == count.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Count plusOne() {
        return new Count(value + 1);
    }

    public int getValue() {
        return value;
    }
}
