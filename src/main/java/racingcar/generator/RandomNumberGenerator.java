package racingcar.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 0;

    private RandomNumberGenerator() {
    }

    public static RandomNumberGenerator getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final RandomNumberGenerator INSTANCE = new RandomNumberGenerator();
    }

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
