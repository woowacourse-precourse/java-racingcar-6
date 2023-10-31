package racingcar.domain.car;

import java.util.Objects;

public class Distance implements Comparable<Distance> {
    private final int value;
    private static final Distance INSTANCE_WITH_ZERO = new Distance(0);
    private static final String MARK = "-";
    private Distance(int value) {
        this.value = value;
    }

    public static Distance zero() {
        return INSTANCE_WITH_ZERO;
    }

    public Distance plusOne() {
        return new Distance(value + 1);
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

    @Override
    public int compareTo(Distance o) {
        return Integer.compare(this.value, o.value);
    }

    public String visualize() {
        return MARK.repeat(value);
    }
}
