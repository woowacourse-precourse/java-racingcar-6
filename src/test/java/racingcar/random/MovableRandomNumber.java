package racingcar.random;

import racingcar.model.RandomNumber;

public class MovableRandomNumber implements RandomNumber {

    private static final int NUMBER = 5;

    @Override
    public int pickNumber() {
        return NUMBER;
    }
}
