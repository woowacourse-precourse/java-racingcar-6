package racingcar.random;

import racingcar.model.RandomNumber;

public class MinusRandomNumber implements RandomNumber {

    private static final int NUMBER = -1;

    @Override
    public int pickNumber() {
        return NUMBER;
    }
}
