package racingcar.domain;

import java.util.Objects;

public class Distance {

    private int value;

    public Distance(final int value) {
        this.value = value;
    }

    public static Distance from(final int distance) {
        return new Distance(distance);
    }

    public void increase() {
        value++;
    }

    public int getMaxDistance(final int presentMax) {
        if (isMax(presentMax)) {
            return value;
        }
        return presentMax;
    }

    public boolean isMax(final int presentMax) {
        return value >= presentMax;
    }

    public int getValue() {
        return value;
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
