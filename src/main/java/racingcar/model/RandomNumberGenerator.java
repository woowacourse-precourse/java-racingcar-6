package racingcar.model;

import static racingcar.model.SystemValueConstants.loopMax;
import static racingcar.model.SystemValueConstants.loopMin;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private final int randomNumber;

    private RandomNumberGenerator(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public static RandomNumberGenerator createNumberGenerator() {
        int randomNumber = Randoms.pickNumberInRange(loopMin(), loopMax());
        return new RandomNumberGenerator(randomNumber);
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
