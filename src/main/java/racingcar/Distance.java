package racingcar;

import java.util.Objects;

public class Distance {

    private int value;

    public Distance(int value) {
        this.value = value;
    }

    public static Distance from(int distance) {
        return new Distance(distance);
    }

    public void increase() {
        value++;
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
