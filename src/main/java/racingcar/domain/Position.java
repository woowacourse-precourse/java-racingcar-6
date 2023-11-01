package racingcar.domain;

import static racingcar.util.ExceptionMessage.INVALID_POSITION;

import java.util.Objects;

public class Position {
    private int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Position move() {
        return new Position(position + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }
}
