package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    private static final RandomNumberGenerator instance = new RandomNumberGenerator();

    private RandomNumberGenerator() {
    }

    public static RandomNumberGenerator getInstance() {
        return instance;
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
