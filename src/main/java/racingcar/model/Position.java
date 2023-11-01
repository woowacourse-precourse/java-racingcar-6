package racingcar.model;

import java.util.Objects;

public class Position {

    public static final int DEFAULT_POSITION = 0;

    private int position;

    public Position() {
        position = DEFAULT_POSITION;
    }

    public void add() {
        position++;
    }

    public int value() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return this.position == position.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}