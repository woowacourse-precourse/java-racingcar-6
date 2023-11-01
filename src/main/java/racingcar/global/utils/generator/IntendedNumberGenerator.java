package racingcar.global.utils.generator;

public class IntendedNumberGenerator implements NumberGenerator {

    private final int number;

    public IntendedNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
