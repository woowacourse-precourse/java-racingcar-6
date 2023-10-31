package racingcar;

import racingcar.common.RandomNumberGenerator;

public class TestRandomNumberGenerator implements RandomNumberGenerator {
    private final int number;

    public TestRandomNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}