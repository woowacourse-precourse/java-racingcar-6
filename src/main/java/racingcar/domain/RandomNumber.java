package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private final int randomNumber;

    private RandomNumber() {
        this.randomNumber = generateNumber();
    }

    public static RandomNumber create() {
        return new RandomNumber();
    }

    private int generateNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    public boolean isMovePossible() {
        return randomNumber >= 4;
    }
}
