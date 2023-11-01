package racingcar.domain;

import java.util.Objects;
import racingcar.domain.strategy.MovingStrategy;

public class CarPosition {
    private static final int MINIMUM_VALUE = 0;

    private final int value;

    private CarPosition(int value) {
        this.value = value;
    }

    public static CarPosition zero() {
        return new CarPosition(MINIMUM_VALUE);
    }

    public static CarPosition from(int value) {
        validateValue(value);
        return new CarPosition(value);
    }

    private static void validateValue(int value) {
        if (value < MINIMUM_VALUE) {
            throw new IllegalArgumentException("자동차의 위치는 양수여야 합니다. 주어진 값은 " + value + " 입니다.");
        }
    }

    public CarPosition move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            return new CarPosition(value + 1);
        }
        return this;
    }

    public boolean biggerThan(CarPosition other) {
        return this.value > other.value;
    }

    public int value() {
        return value;
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
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
