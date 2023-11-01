package racingcar.domain;

import java.util.List;

public class TestNumberGenerator implements NumberGenerator{

    private final List<Integer> numbers;
    private int index;

    public TestNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
        this.index = 0;
    }

    @Override
    public int generate() {
        return numbers.get(index++);
    }
}
