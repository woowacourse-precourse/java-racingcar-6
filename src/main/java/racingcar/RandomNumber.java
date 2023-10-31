package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private static final int MINIMUM_VALUE = 0;
    private static final int MAXIMUM_VALUE = 9;

    private final int number;

    RandomNumber() {
        this.number = Randoms.pickNumberInRange(MINIMUM_VALUE, MAXIMUM_VALUE);
    }

    RandomNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
