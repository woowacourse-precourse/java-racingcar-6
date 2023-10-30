package racingcar.domain;

import java.util.Objects;

public class Position {

    private static final int START_POSITION = 0;

    private int position;

    public Position() {
        this.position = START_POSITION;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position++;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return getPosition() == position1.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }

}
