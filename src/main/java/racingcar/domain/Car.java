package racingcar.domain;

import racingcar.constant.IllegalArgumentExceptionType;

public abstract class Car {
    private static final int INIT_DISTANCE = 0;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    protected final String name;
    protected int distance = INIT_DISTANCE;

    public Car(String name) {
        this.name = name;
        validateIsCarNameEmpty();
        validateIsCarNameExceedingMaxLength();
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

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

    public boolean isMaxDistance(int maxDistance) {
        return distance == maxDistance;
    }

    public void attemptToMove() {
        if (isMovable()) {
            distance++;
        }
    }

    public abstract boolean isMovable();
}
