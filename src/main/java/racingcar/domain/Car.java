package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int moveDistance;
    private final int MAX_CAR_NAME_LENGTH = 5;
    private final int TEST_SUCCESS_MOVE_RANDOM_PARAMETER_MIN_VALUE = 0;
    private final int TEST_SUCCESS_MOVE_RANDOM_PARAMETER_MAX_VALUE = 9;
    private final int SUCCESS_MOVE_CRITERIA_VALUE = 4;
    private final int WHEN_SUCCESS_MOVE_DISTANCE = 1;
    private final int WHEN_FAIL_MOVE_DISTANCE = 0;

    public Car(String name) {
        this.name = validCarName(name);
    }

    public Car(String name, int moveDistance) {
        this.name = validCarName(name);
        this.moveDistance = moveDistance;
    }

    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public void randomMove() {
        int parameter = getRandomNumber();
        moveDistance += calculateDistance(parameter);
    }

    private String validCarName(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        return name;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(TEST_SUCCESS_MOVE_RANDOM_PARAMETER_MIN_VALUE
                , TEST_SUCCESS_MOVE_RANDOM_PARAMETER_MAX_VALUE);
    }

    private int calculateDistance(int parameter) {
        if (isSuccessMove(parameter)) {
            return WHEN_SUCCESS_MOVE_DISTANCE;
        }
        return WHEN_FAIL_MOVE_DISTANCE;
    }

    private boolean isSuccessMove(int parameter) {
        return parameter >= SUCCESS_MOVE_CRITERIA_VALUE;
    }
}
