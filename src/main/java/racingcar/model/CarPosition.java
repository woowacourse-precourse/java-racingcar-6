package racingcar.model;

import static racingcar.model.ExceptionMessage.POSITION_UNDER_LIMIT_FORMAT_MESSAGE;

import java.util.Objects;

public final class CarPosition implements Comparable<CarPosition> {
    private static final int MIN_POSITION = 0;
    private static final int MOVE_STEP = 1;

    private final int position;

    CarPosition(int position) {
        validateMin(position);
        this.position = position;
    }

    private void validateMin(int position) {
        if (isLessThanMin(position)) {
            String exceptionMessage = String.format(POSITION_UNDER_LIMIT_FORMAT_MESSAGE, MIN_POSITION);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private boolean isLessThanMin(int position) {
        return position < MIN_POSITION;
    }

    public static CarPosition initialPosition() {
        return new CarPosition(MIN_POSITION);
    }

    public CarPosition move() {
        return new CarPosition(position + MOVE_STEP);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(CarPosition otherCarPosition) {
        return Integer.compare(position, otherCarPosition.position);
    }

    @Override
    public boolean equals(Object o) {
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
