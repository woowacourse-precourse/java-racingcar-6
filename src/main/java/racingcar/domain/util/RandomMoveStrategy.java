package racingcar.domain.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    public static final int MIN_NUM = 4;
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    @Override
    public boolean move() {
        int randomValue = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
        return randomValue >= MIN_NUM;
    }
}