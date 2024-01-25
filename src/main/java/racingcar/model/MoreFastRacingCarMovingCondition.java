package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.RacingCarRole;

public class MoreFastRacingCarMovingCondition implements MovingCondition {

    private static final int MIN_NUMBER = 2;
    private static final int MAX_NUMBER = 5;


    @Override
    public boolean canMove() {
        int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        return number >= RacingCarRole.MOVING_CONDITION.getValue();
    }
}
