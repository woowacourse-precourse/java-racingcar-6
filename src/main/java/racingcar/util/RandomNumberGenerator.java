package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public abstract class RandomNumberGenerator {
    private static final int LOWER_LIMIT = 0;
    private static final int UPPER_LIMIT = 9;

    public static int generate() {
        return Randoms.pickNumberInRange(LOWER_LIMIT, UPPER_LIMIT);
    }
}
