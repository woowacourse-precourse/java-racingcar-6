package racingcar.model;

import java.util.Objects;

public class Position {

    private static final int MIN_MOVE_STANDARD = 4;
    private static final int INITIAL_POSITION = 0;

    private int position;

    private Position(final int position) {
        this.position = position;
    }

    public static Position createDefault() {
        return new Position(INITIAL_POSITION);
    }

    public void move(final int number) {
        if (canMove(number)) {
            position++;
        }
    }

    private boolean canMove(final int number) {
        return number >= MIN_MOVE_STANDARD;
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
