package racingcar.service;

public class Rule {

    private static final int MOVING_CONDITION = 4;

    public boolean isMovingCondition(int number) {
        return number >= MOVING_CONDITION;
    }
}
