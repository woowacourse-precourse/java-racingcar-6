package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;
    private static final int MIN_MOVABLE_NUMBER = 4;

    @Override
    public boolean canMove() {
        return Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE) >= MIN_MOVABLE_NUMBER;
    }
}
