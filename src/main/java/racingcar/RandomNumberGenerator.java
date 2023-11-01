package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private int randomNumber;

    public int generateRandomNumber() {
        this.randomNumber = Randoms.pickNumberInRange(0, 9);
        return this.randomNumber;
    }

    public int getRandomNumber() {
        return this.randomNumber;
    }
}