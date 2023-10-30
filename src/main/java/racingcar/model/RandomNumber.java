package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private final int randomNumber;

    private RandomNumber() {
        this.randomNumber = Randoms.pickNumberInRange(0, 9);
    }

    public static RandomNumber createNumber() {
        return new RandomNumber();
    }

    public int getNumber() {
        return this.randomNumber;
    }
}
