package racingcar.model;

public class TestRandomGenerator implements RandomGenerator{

    private final int fixedValue;

    public TestRandomGenerator(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int pick() {
        return fixedValue;
    }
}
