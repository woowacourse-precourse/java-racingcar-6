package racingcar.domain;


import static racingcar.exception.ErrorMessage.NEGATIVE_POSITION;

import java.util.Objects;
import racingcar.exception.RacingGameException;

public class Position {
    private static final int CAR_ONE_STEP = 1;
    private int position;

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < 0) {
            throw RacingGameException.of(NEGATIVE_POSITION);
        }

    }

    public void plus() {
        this.position += CAR_ONE_STEP;
    }

    public int getPosition() {
        return position;
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

}
