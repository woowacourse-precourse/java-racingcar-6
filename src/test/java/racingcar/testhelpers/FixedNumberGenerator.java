package racingcar.testhelpers;

import racingcar.util.RandomNumberGenerator;

public class FixedNumberGenerator implements RandomNumberGenerator {

    private final int fixedNumber;

    public FixedNumberGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int generate() {
        return fixedNumber;
    }
}

