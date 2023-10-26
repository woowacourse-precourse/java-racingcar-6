package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final int MIN_POSITION = 0;

    private int position;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < MIN_POSITION) {
            throw new IllegalArgumentException(
                    String.format("자동차의 위치는 %d보다 작을 수 없습니다.", MIN_POSITION)
            );
        }
    }

    public void increase() {
        position++;
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

    @Override
    public int compareTo(Position other) {
        return this.position - other.position;
    }
}
