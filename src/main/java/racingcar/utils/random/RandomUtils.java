package racingcar.utils.random;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {

    private static final int DEFAULT_MIN = 0;
    private static final int DEFAULT_MAX = 9;

    private RandomUtils() {
        throw new UnsupportedOperationException();
    }

    public static Integer pick() {
        return RandomUtils.pick(DEFAULT_MIN, DEFAULT_MAX);
    }

    public static Integer pick(final int startRange, final int endRange) {
        return Randoms.pickNumberInRange(startRange, endRange);
    }
}
