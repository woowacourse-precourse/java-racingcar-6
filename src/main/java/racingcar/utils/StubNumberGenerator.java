package racingcar.utils;

public class StubNumberGenerator implements NumberGenerator {
    private final int fixedNumber;

    public StubNumberGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int generateNumberInRange() {
        return fixedNumber;
    }
}
