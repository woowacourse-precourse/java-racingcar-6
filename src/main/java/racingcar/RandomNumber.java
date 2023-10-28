package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private final int number;

    RandomNumber() {
        this.number = Randoms.pickNumberInRange(0, 9);
    }

    RandomNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
