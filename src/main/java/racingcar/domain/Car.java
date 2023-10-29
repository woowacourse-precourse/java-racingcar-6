package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.IllegalArgumentExceptionType;

public class Car {
    private static final int INIT_DISTANCE = 0;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MOVING_FORWARD = 4;
    private static final int MIN_MOVE_RANGE = 0;
    private static final int MAX_MOVE_RANGE = 9;

    private final String name;
    private int distance = INIT_DISTANCE;

    public Car(String name) {
        this.name = name;
        validateIsCarNameEmpty();
        validateIsCarNameExceedingMaxLength();
    }

    public String getName() {
        return name;
    }

    public int getDistance() { return distance; }

    public boolean isMaxDistance(int maxDistance) { return distance == maxDistance; }

    private void validateIsCarNameEmpty() {
        if (name.isEmpty()) {
            throw IllegalArgumentExceptionType.CAR_NAME_MIN_LENGTH_ERROR_MESSAGE.getException();
        }
    }
    private void validateIsCarNameExceedingMaxLength() {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw IllegalArgumentExceptionType.CAR_NAME_MAX_LENGTH_ERROR_MESSAGE.getException();
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(MIN_MOVE_RANGE, MAX_MOVE_RANGE) >= MOVING_FORWARD;
    }

    void attemptToMove() {
        if (isMovable()) {
            distance++;
        }
    }
}
