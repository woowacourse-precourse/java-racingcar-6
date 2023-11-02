package racingcar.model;

import java.util.Objects;

public class CarPosition {

    private static final int MIN_POSITION_VALUE = 0;
    private static final int MOVE_FORWARD_STEP = 1;
    private static final int INITIAL_STEP = 0;

    private int position;

    public CarPosition(final int position) {
        validate(position);
        this.position = position;
    }

    private void validate(final int position) {
        if (position < MIN_POSITION_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    public static CarPosition withZero() {
        return new CarPosition(INITIAL_STEP);
    }

    public void moveForward() {
        this.position += MOVE_FORWARD_STEP;
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
        final CarPosition other = (CarPosition) o;
        return position == other.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
