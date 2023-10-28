package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private final int randomNumber;

    public RandomNumber() {
        this.randomNumber = generateNumber();
    }

    private int generateNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    public boolean isMovePossible() {
        return randomNumber >= 4;
    }
}
