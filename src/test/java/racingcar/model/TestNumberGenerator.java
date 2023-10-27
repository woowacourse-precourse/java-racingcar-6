package racingcar.model;

import racingcar.utils.NumberGenerator;

public class TestNumberGenerator implements NumberGenerator {
    private int testValue;

    public TestNumberGenerator(int testValue) {
        this.testValue = testValue;
    }

    @Override
    public int generateNumber() {
        return testValue;
    }
}