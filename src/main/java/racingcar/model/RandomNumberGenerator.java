package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private final int randomNumber;
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;

    private RandomNumberGenerator(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public static RandomNumberGenerator createNumberGenerator() {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
        return new RandomNumberGenerator(randomNumber);
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
