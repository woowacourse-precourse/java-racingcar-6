package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int RANDOM_NUMBER_MIN_VALUE = 0;
    private static final int RANDOM_NUMBER_MAX_VALUE = 9;

    private RandomNumberGenerator() {
    }

    public static int generate() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN_VALUE, RANDOM_NUMBER_MAX_VALUE);
    }
}
