package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator{
    private static final int MINIMUM_NUMBER_RANGE = 0;
    private static final int MAXIMUM_NUMBER_RANGE = 9;
    private static RandomNumberGenerator instance;

    private RandomNumberGenerator() {}

    public static RandomNumberGenerator getInstance() {
        if (instance == null) {
            instance = new RandomNumberGenerator();
        }
        return instance;
    }

    public int generate() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER_RANGE, MAXIMUM_NUMBER_RANGE);
    }
}
