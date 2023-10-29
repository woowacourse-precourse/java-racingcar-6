package racingcar.model;

import java.util.Objects;

public class Position {

    private int position;

    public Position() {
        position = 0;
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