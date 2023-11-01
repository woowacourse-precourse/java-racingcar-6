package racingcar.domain;

public class FixedNumberGenerator implements NumberGenerator {
    private static final int MINIMAL_NUMBER = 4;

    private final int number;

    public FixedNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public boolean generate() {
        return number >=  MINIMAL_NUMBER;
    }
}
