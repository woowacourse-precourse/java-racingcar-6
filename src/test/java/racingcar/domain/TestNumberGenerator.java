package racingcar.domain;

public class TestNumberGenerator implements NumberGenerator {
    private final int fixedNumber;

    public TestNumberGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int createRandomNumber() {
        return fixedNumber;
    }
}
