package racingcar.domain;

import java.util.Objects;

public class Position {
    private final int distance;
    private final int MIN_DISTANCE = 0;
    private int MOVING_DISTANCE = 1;

    public Position(int distance) {
        if (distance < MIN_DISTANCE) {
            throw new IllegalArgumentException();
        }
        this.distance = distance;
    }

    public Position move() {
        return new Position(distance + MOVING_DISTANCE);
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
