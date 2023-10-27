package racingcar.domain;

import racingcar.constant.MovementRule;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean isMovable(int randomNumber) {
        return randomNumber >= MovementRule.FORWARD_MINIMUM_VALUE.getValue();
    }
}
