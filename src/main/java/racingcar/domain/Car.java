package racingcar.domain;

import static racingcar.constants.MessageConstant.INVALID_CAR_NAME_MESSAGE;
import static racingcar.constants.MessageConstant.MOVE_TRAIL_INDICATOR;
import static racingcar.constants.MessageConstant.PRINT_CAR_INFO_FORMAT;
import static racingcar.constants.NumberConstant.MAXIMUM_CAR_NAME_LENGTH;
import static racingcar.constants.NumberConstant.MINIMUM_CAR_NAME_LENGTH;
import static racingcar.constants.NumberConstant.MOVING_FORWARD_LENGTH;

import org.junit.platform.commons.util.StringUtils;

public class Car {

    private final String name;
    private final int move;

    public static Car of(final String name) {
        return new Car(name, 0);
    }

    private Car(final String name, final int move) {
        validate(name);
        this.name = name;
        this.move = move;
    }

    public String getName() {
        return name;
    }

    public int getMove() {
        return move;
    }

    public Car increaseMove() {
        return new Car(name, move + MOVING_FORWARD_LENGTH);
    }

    public String receiveMoveTrail() {
        return MOVE_TRAIL_INDICATOR.repeat(move);
    }

    public boolean compare(final int forwardCount) {
        return this.move == forwardCount;
    }

    private void validate(final String name) {
        checkInput(name);
        checkLength(name);
    }

    private void checkLength(final String name) {
        if (isNameLengthOutOfRange(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
    }

    private boolean isNameLengthOutOfRange(final String name) {
        int length = name.length();
        return length < MINIMUM_CAR_NAME_LENGTH || length > MAXIMUM_CAR_NAME_LENGTH;
    }

    private void checkInput(final String name) {
        if (hasBlank(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
    }

    private boolean hasBlank(final String name) {
        return StringUtils.containsWhitespace(name);
    }

    @Override
    public String toString() {
        return String.format(PRINT_CAR_INFO_FORMAT, name, receiveMoveTrail());
    }
}
