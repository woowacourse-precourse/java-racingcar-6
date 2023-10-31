package racingcar.service;

public class BasicMovementRule implements Rule {

    private static final int MOVING_CONDITION = 4;

    public boolean isMovingCondition(int randomNumber) {
        return randomNumber >= MOVING_CONDITION;
    }
}
