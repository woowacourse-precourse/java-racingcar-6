package racingcar.domain;

import java.util.Objects;

public class Position {
    private int position;

    public Position(int position) {
        this.position = validation(position);
    }

    private int validation(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position은 음수값을 가질 수 없습니다.");
        }
        return position;
    }

    public Position move() {
        return new Position(position + 1);
    }

    public int getPosition() {
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
