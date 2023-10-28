package racingcar.model;

import java.util.Objects;

public final class Position implements Comparable<Position> {
    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position startFromZero() {
        return new Position(0);
    }

    static Position of(int position) {
        return new Position(position);
    }

    public Position move() {
        return new Position(position + 1);
    }

    @Override
    public int compareTo(Position position) {
        return Integer.compare(this.position, position.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    /*
    * 자동차의 위치를 반환한다.
    * "-"를 position 만큼 반복하여 반환한다.
    */
    @Override
    public String toString() {
        return "-".repeat(position);
    }
}
