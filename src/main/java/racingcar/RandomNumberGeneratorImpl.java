package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {
    private final int MIN_RANDOM_NUMBER = 0;
    private final int MAX_RANDOM_NUMBER = 9;

    private static final RandomNumberGeneratorImpl instance = new RandomNumberGeneratorImpl();

    private RandomNumberGeneratorImpl() {}

    public static RandomNumberGeneratorImpl getInstance() {
        return instance;
    }

    @Override
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}

