package racingcar.helper;

import racingcar.util.NumberGenerator;

public class StubNumberGenerator implements NumberGenerator {

    private final int number;

    public StubNumberGenerator(final int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
