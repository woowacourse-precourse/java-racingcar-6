package racingcar.domain;

import java.util.Objects;

public class Position {

    private static final int START_POSITION = 0;
    private static final int MOVING_DISTANCE = 1;

    private int position;

    public Position() {
        this.position = START_POSITION;
    }

    public void moveForward() {
        this.position += MOVING_DISTANCE;
    }

    public int getPosition() {
        return position;
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
