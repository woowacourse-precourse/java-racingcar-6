package racingcar.domain.car;

import java.util.Objects;

public class Distance {
    private final int value;

    public Distance(int value) {
        this.value = value;
    }

    public Distance add(int addend) {
        return new Distance(value + addend);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Distance distance = (Distance) o;
        return value == distance.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
