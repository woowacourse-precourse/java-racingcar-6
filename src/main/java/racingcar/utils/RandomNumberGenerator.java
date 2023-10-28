package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int MINIMUM_NUMBER_RANGE = 0;
    private static final int MAXIMUM_NUMBER_RANGE = 9;

    private RandomNumberGenerator() {}

    public static int generate() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER_RANGE, MAXIMUM_NUMBER_RANGE);
    }
}
