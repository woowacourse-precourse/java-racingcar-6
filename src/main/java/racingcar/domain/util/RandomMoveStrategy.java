package racingcar.domain.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    public static final int MIN_NUM = 4;

    @Override
    public boolean move() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= MIN_NUM;
    }
}