package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.MoveStrategy;

public class RandomGenerator implements MoveStrategy {
    private static final int FORWARD_NUM = 4;

    @Override
    public boolean canMove() {
        return generate() >= FORWARD_NUM;

    }
    public static int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
