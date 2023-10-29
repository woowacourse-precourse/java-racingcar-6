package racingcar.domain;

import racingcar.constant.ErrorMessage;
import racingcar.constant.MoveStatus;

public final class Number {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;
    private static final int MOVE_STANDARD = 4;
    private final int value;

    public Number(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.toValue());
        }
    }

    public MoveStatus checkMoveStatus() {
        if (isMovable()) {
            return MoveStatus.MOVE;
        }
        return MoveStatus.STOP;
    }

    private boolean isMovable() {
        return value >= MOVE_STANDARD;
    }
}
