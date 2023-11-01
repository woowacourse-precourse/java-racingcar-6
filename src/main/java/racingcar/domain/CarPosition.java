package racingcar.domain;

import java.util.Objects;

public class CarPosition {

    private static final int ZERO_POSITION = 0;

    private int position;

    private CarPosition(final int position) {
        validate(position);
        this.position = position;
    }

    public static CarPosition zeroPosition() {
        return new CarPosition(ZERO_POSITION);
    }

    public static CarPosition from(final int position) {
        return new CarPosition(position);
    }

    private void validate(final int position) {
        if (position < ZERO_POSITION) {
            throw new IllegalArgumentException("자동차 위치는 0보다 크거나 같아야 합니다.");
        }
    }

    public void move() {
        this.position++;
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
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
