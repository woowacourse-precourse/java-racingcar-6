package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int MIN = 0;
    private static final int MAX = 9;

    private RandomNumberGenerator() {
    }

    private static class RandomNumberGeneratorHolder {
        private static RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    }

    public static RandomNumberGenerator getInstance() {
        return RandomNumberGenerator.RandomNumberGeneratorHolder.randomNumberGenerator;
    }

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
