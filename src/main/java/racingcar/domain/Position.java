package racingcar.domain;


import static racingcar.constant.CarConstant.CAR_ONE_STEP;
import static racingcar.constant.CarConstant.CAR_START_POSITION;
import static racingcar.exception.ErrorMessage.NEGATIVE_POSITION;

import java.util.Objects;
import racingcar.exception.RacingGameException;

public class Position implements Comparable<Position> {

    private int value;

    public Position(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int position) {
        if (position < CAR_START_POSITION) {
            throw RacingGameException.of(NEGATIVE_POSITION);
        }

    }

    public void plus() {
        this.value += CAR_ONE_STEP;
    }

    public int getValue() {
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

        Position position1 = (Position) o;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Position o) {
        if (this.equals(o)) {
            return 0;
        }

        if (this.value > o.value) {
            return 1;
        }

        return -1;
    }
}
