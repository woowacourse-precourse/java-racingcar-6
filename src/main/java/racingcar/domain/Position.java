package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final String INVALID_INPUT_MESSAGE = "음수는 입력할 수 없습니다.";
    private static final int DEFAULT_POSITION = 0;

    private int value;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(int value) {
        if (value < DEFAULT_POSITION) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
        this.value = value;
    }

    public int getValue() { return value; }

    public void increase() {
        this.value += 1;
    }

    public Position copy() {
        return new Position(this.value);
    }

    public boolean isGreaterThen(Position position) {
        if(compareTo(position) <= DEFAULT_POSITION) return false;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Position o) {
        return this.value - o.value;
    }
}
