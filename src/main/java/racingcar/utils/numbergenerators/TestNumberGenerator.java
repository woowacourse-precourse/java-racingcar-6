package racingcar.utils.numbergenerators;

public class TestNumberGenerator implements NumberGenerator {
    private final int testValue;

    public TestNumberGenerator(int testValue) {
        this.testValue = testValue;
    }

    @Override
    public int generateNumber() {
        return testValue;
    }
}