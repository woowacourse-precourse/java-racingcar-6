package racingcar.random;

import racingcar.model.RandomNumber;

public class HigherRandomNumber implements RandomNumber {

    private static final int NUMBER = 10;

    @Override
    public int pickNumber() {
        return NUMBER;
    }
}
