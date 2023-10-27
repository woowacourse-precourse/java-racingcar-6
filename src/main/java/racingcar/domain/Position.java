package racingcar.domain;

import java.util.Objects;

public class Position {

    private static final String INVALID_INPUT_MESSAGE = "음수는 입력할 수 없습니다.";
    private static final int DEFAULT_POSITION = 0;

    private int value;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
        this.value = value;
    }

    public void increase() {
        this.value += 1;
    }

    public Position copy() {
        return new Position(this.value);
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
}
