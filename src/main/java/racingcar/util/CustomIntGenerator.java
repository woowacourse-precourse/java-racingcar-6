package racingcar.util;

public class CustomIntGenerator implements IntGenerator {

    private final int number;

    public CustomIntGenerator(int number) {
        this.number = number;
    }

    @Override
    public int pickNumber() {
        return number;
    }
}
