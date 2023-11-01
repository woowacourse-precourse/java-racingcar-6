package racingcar.util.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    private static final NumberGenerator INSTANCE = new RandomNumberGenerator();

    private RandomNumberGenerator() {
    }

    public static NumberGenerator getInstance() {
        return INSTANCE;
    }

    @Override
    public int generate() {
        return createRandomNumber();
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
