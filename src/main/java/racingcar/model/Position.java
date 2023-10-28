package racingcar.model;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final Position ZERO = new Position(0);
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position of(int position) {
        return new Position(position);
    }

    public static Position zero() {
        return ZERO;
    }

    public Position move() {
        return new Position(position + 1);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Position o) {
        return position - o.position;
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
}
