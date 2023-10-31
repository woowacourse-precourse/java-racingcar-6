package racingcar.engine;

import racingcar.generator.NumberGenerator;

public class ReturnGenerator implements NumberGenerator {
    private final int returnValue;

    public ReturnGenerator() {
        returnValue = 0;
    }

    public ReturnGenerator(int returnValue) {
        this.returnValue = returnValue;
    }

    @Override
    public int generate(int startInclusive, int endInclusive) {
        return returnValue;
    }
}
