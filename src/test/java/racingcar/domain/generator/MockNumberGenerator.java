package racingcar.domain.generator;

public class MockNumberGenerator implements NumberGenerator {

    private final int value;

    public MockNumberGenerator(int value) {
        this.value = value;
    }

    @Override
    public int generate() {
        return value;
    }
}
