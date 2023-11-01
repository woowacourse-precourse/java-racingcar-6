package racingcar.service;

import racingcar.domain.IntegerConstant;

public class BasicMovementRule implements Rule {

    public boolean isMovingCondition(int randomNumber) {
        return randomNumber >= IntegerConstant.MOVING_CONDITION.getValue();
    }
}
