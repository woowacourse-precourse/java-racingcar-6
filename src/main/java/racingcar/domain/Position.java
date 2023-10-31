package racingcar.domain;

import java.util.Objects;

public class Position {

    private final int position;

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 0 이상이어야 합니다.");
        }
    }

    public Position increase() {
        return new Position(this.position + 1);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Position position1 = (Position) object;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public int getPosition() {
        return position;
    }

}
