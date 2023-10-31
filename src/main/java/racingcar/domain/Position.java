package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final int ONE_STEP = 1;
    private static final int START_POSITION = 0;

    private int position;

    public Position() {
        this.position = START_POSITION;
    }

    public void increase() {
        position += ONE_STEP;
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
        Position that = (Position) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(Position o) {
        return this.position - o.position;
    }
}
