package racingcar.mock;

import racingcar.domain.condition.MoveCondition;

public class FakeMoveCondition implements MoveCondition {

    private int count;

    @Override
    public boolean isMove() {
        count++;
        return (count & 1) == 0;
    }
}
