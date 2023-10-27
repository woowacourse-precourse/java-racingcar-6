package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private int randomNumber;

    public RandomNumber() {
        randomNumber = Randoms.pickNumberInRange(0, 9);
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
