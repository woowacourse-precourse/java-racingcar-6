package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int MOVE_CONDITION = 4;

    private RandomNumberGenerator() {
        throw new AssertionError();
    }

    public static boolean canMove() {
        return Randoms.pickNumberInRange(0,9) >= MOVE_CONDITION;
    }
}
