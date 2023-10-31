package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private int position;

    public Position() {
        this.position = 0;
    }

    public void shift(int input) {
        this.position += input;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.position, o.position);
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
