package racingcar.domain.condition;

import static racingcar.constant.RacingGameConstant.MOVE_CONDITION_NUMBER;

public class MoveCondition {

    public boolean check(int number) {
        return number >= MOVE_CONDITION_NUMBER;
    }
}
