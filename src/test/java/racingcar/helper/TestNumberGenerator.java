package racingcar.helper;

import racingcar.util.NumberGenerator;

public class TestNumberGenerator implements NumberGenerator {

    private final int number;

    public TestNumberGenerator(final int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
