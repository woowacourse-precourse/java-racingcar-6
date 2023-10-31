package racingcar.domain;

import java.util.List;

public class MockRandomNumberGenerator implements NumberGenerator {
    private final List<Integer> expected;
    private int index = 0;

    public MockRandomNumberGenerator(List<Integer> expected) {
        this.expected = expected;
    }

    @Override
    public int makeRandomNumber() {
        return expected.get(index++);
    }
}
