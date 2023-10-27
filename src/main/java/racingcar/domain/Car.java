package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final String CAR_NAME_ERROR_MESSAGE = "차량 이름의 길이 제한은 1~5입니다.";
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MOVING_FORWARD = 4;

    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
        validate();
    }

    public String getName() {
        return name;
    }
    public int getDistance() { return distance; }
    public boolean isMaxDistance(int maxDistance) { return distance == maxDistance; }

    private void validateIsCarNameEmpty() {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
        }
    }
    private void validateIsCarNameExceedingMaxLength() {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
        }
    }

    private void validate() {
        validateIsCarNameEmpty();
        validateIsCarNameExceedingMaxLength();
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
