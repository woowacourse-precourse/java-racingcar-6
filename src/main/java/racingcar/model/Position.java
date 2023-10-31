package racingcar.model;

import racingcar.dto.PositionDto;

import java.util.Objects;

public class Position {

    private static final int INIT_POSITION = 0;

    private final int position;

    public Position(final int position) {
        validate(position);
        this.position = position;
    }

    public Position() {
        this(INIT_POSITION);
    }

    private void validate(final int position) {
        if (position < INIT_POSITION) {
            throw new IllegalArgumentException("[Error] 초기위치값은 0보다 작을 수 없습니다.");
        }
    }

    public Position move() {
        return new Position(position + 1);
    }

    public boolean isFrontOf(Position other) {
        return position > other.position;
    }

    public PositionDto toDto() {
        return new PositionDto(position);
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
}
