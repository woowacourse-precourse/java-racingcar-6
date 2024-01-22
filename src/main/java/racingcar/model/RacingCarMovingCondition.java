package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import org.springframework.stereotype.Component;
import racingcar.constants.RacingCarRole;

@Component
public class RacingCarMovingCondition implements MovingCondition{

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    @Override
    public boolean canMove() {
        int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        return number >= RacingCarRole.MOVING_CONDITION.getValue();
    }
}
