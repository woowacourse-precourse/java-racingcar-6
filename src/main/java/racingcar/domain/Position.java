package racingcar.domain;

import java.util.Objects;

public class Position {

    private int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        if(value < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        this.value = value;
    }

    public void increase() {
        this.value += 1;
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
