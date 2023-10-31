package racingcar.model.number;

public class InputNumberGenerator implements NumberGenerator {
    private final int number;

    public InputNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
