package racingcar.domain.car;

import racingcar.domain.formula.Formula;
import racingcar.domain.formula.MoveState;

public class Car implements Comparable<Car> {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_POSITION = 0;

    private final String name;
    private int position;

    public Car(final String name, final int position) {
        validateName(name);
        validatePosition(position);
        this.name = name;
        this.position = position;
    }

    private void validateName(final String name) {
        isNameLengthValid(name);
    }

    private void isNameLengthValid(final String name) {
        if (name.isEmpty() || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    private void validatePosition(final int position) {
        isPositionValid(position);
    }

    private void isPositionValid(final int position) {
        if (position < MINIMUM_POSITION) {
            throw new IllegalArgumentException("위치는 0 이상만 가능합니다.");
        }
    }

    public int move(final Formula formula) {
        if (formula.move() == MoveState.MOVING_FORWARD) {
            position++;
        }
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isSamePosition(final Car other) {
        return this.position == other.position;
    }

    @Override
    public int compareTo(final Car other) {
        return this.position - other.position;
    }
}
