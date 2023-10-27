package racingcar.domain;

import racingcar.constant.MovementRule;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean isMovable(int randomNumber) {
        return randomNumber >= MovementRule.MOVE_THRESHOLD.getValue();
    }
}
