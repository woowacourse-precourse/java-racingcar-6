package racingcar;

import java.util.Objects;

public class Distance {

    private final int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public static Distance from(int distance) {
        return new Distance(distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
