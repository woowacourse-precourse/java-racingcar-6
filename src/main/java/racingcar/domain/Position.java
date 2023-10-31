package racingcar.domain;

import java.util.Objects;

public class Position {
    private final int distance;

    public Position(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException();
        }
        this.distance = distance;
    }

    public Position move() {
        return new Position(distance + 1);
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return distance == position.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
