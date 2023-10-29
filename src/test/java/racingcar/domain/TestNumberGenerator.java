package racingcar.domain;

public class TestNumberGenerator implements Generator{

    private final int number;

    public TestNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public Integer generate() {
        return number;
    }
}
