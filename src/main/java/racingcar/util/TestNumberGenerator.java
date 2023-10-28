package racingcar.util;

public class TestNumberGenerator implements NumberGenerator{

    private int[] testNumbers;
    private int index;

    public TestNumberGenerator(int[] testNumbers) {
        this.testNumbers = testNumbers;
    }

    @Override
    public int generate() {
        return testNumbers[index++];
    }
}
