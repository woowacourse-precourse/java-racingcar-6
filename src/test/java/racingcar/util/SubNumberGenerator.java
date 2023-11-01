package racingcar.util;

public class SubNumberGenerator implements NumberGenerator {
    private final int number;

    public SubNumberGenerator(int number) {
        this.number = number;
    }

    public int generate() {
        return number;
    }
}
