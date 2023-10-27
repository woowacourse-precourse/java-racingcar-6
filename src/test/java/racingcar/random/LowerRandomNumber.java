package racingcar.random;

import racingcar.model.RandomNumber;

public class LowerRandomNumber implements RandomNumber {

    private static final int NUMBER = 3;

    @Override
    public int pickNumber() {
        return NUMBER;
    }
}
