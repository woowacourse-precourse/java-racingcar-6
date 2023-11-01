package racingcar.entity.policy;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.entity.MovePolicy;

public class RandomMovePolicy implements MovePolicy {

    private static final int MIN_NUMBER_RANGE = 0;
    private static final int MAX_NUMBER_RANGE = 9;
    private static final int MOVABLE_NUMBER = 4;

    @Override
    public boolean isMovable() {
        int random = Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);

        return random >= MOVABLE_NUMBER;
    }
}
