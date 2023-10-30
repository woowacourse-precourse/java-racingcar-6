package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    private static final NumberGenerator INSTANCE = new RandomNumberGenerator();

    private RandomNumberGenerator() {
    }

    public static NumberGenerator getInstance() {
        return INSTANCE;
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
