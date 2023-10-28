package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;

public class Car {

    private static final String INVALID_CAR_NAME_MESSAGE = "잘못된 입력입니다.";
    private static final String CAR_TO_STRING = "%s : %s";
    private static final String MOVE_TRAIL_INDICATOR = "-";
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final int MOVING_FORWARD_LENGTH = 1;

    private final String name;
    private final int move;

    public static Car of(String name) {
        return new Car(name, 0);
    }

    private Car(String name, int move) {
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

    public boolean compare(int forwardCount) {
        return this.move == forwardCount;
    }

    private void validate(String name) {
        checkInput(name);
        checkLength(name);
    }

    private void checkLength(String name) {
        if (isCarNameLengthOutOfRange(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
    }

    private boolean isCarNameLengthOutOfRange(String name) {
        int length = name.length();
        return length < MINIMUM_CAR_NAME_LENGTH || length > MAXIMUM_CAR_NAME_LENGTH;
    }

    private void checkInput(String name) {
        if (hasBlank(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
    }

    private boolean hasBlank(String name) {
        return StringUtils.containsWhitespace(name);
    }

    @Override
    public String toString() {
        return String.format(CAR_TO_STRING, name, receiveMoveTrail());
    }
}
