package racingcar.domain;

import racingcar.util.NumberGenerator;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int FORWARD_CONDITION_NUMBER = 4;
    private static final int RANDOM_RANGE_START_NUMBER = 0;
    private static final int RANDOM_RANGE_END_NUMBER = 9;
    private static final String EXCEED_NAME_LENGTH_MESSAGE = "자동차 이름은 5자 이하만 가능 합니다.";

    private final String name;
    private int movementCount;

    public Car(String name) {
        checkNameLength(name);
        this.name = name;
        this.movementCount = 0;
    }

    public Boolean isPossibleForward() {
        int randomNumber = NumberGenerator.generateRandomNumberInRange(RANDOM_RANGE_START_NUMBER,
                RANDOM_RANGE_END_NUMBER);
        if (randomNumber >= FORWARD_CONDITION_NUMBER) {
            return true;
        }
        return false;
    }

    private void checkNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(EXCEED_NAME_LENGTH_MESSAGE);
        }
    }

}
