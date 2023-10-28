package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private final int randomNumber;

    private RandomNumberGenerator(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public static RandomNumberGenerator newInstance() {
        int randomNumber = pickRandomNumber();
        return new RandomNumberGenerator(randomNumber);
    }

    public static int pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
