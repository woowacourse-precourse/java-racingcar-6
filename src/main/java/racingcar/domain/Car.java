package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.IllegalArgumentExceptionType;

public class Car {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MOVING_FORWARD = 4;

    private final String name;
    private int distance = 0;

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
            IllegalArgumentExceptionType.CAR_NAME_MIN_LENGTH_ERROR_MESSAGE.throwException();
        }
    }
    private void validateIsCarNameExceedingMaxLength() {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            IllegalArgumentExceptionType.CAR_NAME_MAX_LENGTH_ERROR_MESSAGE.throwException();
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= MOVING_FORWARD;
    }

    void attemptToMove() {
        if (isMovable()) {
            distance++;
        }
    }
}
