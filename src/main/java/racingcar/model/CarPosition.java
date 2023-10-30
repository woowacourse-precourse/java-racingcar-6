package racingcar.model;

import java.util.Objects;

public final class CarPosition implements Comparable<CarPosition> {
    private static final String POSITION_UNDER_LIMIT_FORMAT_MESSAGE = "자동차의 위치는 %d보다 작을 수 없습니다.";
    private static final int INITIAL_POSITION = 0;
    private static final int MOVE_STEP = 1;

    private final int position;

    CarPosition(int position) {
        validateMin(position);
        this.position = position;
    }

    private void validateMin(int position) {
        if (isLessThanInitial(position)) {
            String exceptionMessage = String.format(POSITION_UNDER_LIMIT_FORMAT_MESSAGE, INITIAL_POSITION);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private boolean isLessThanInitial(int position) {
        return position < INITIAL_POSITION;
    }

    public static CarPosition initialPosition() {
        return new CarPosition(INITIAL_POSITION);
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
