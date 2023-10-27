package racingcar.model;

import java.util.Objects;

public class Position {

    private static final int STANDARD = 4;

    private int position;

    public Position(final int position) {
        this.position = position;
    }

    public void move(final int number) {
        if (canMove(number)) {
            position++;
        }
    }

    private boolean canMove(final int number) {
        return number >= STANDARD;
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

    public int getPosition() {
        return position;
    }
}
