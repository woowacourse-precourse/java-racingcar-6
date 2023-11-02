package racingcar.util.mock;

import racingcar.util.NumberGenerator;

import java.util.Iterator;
import java.util.List;

public class MockNumberGenerator implements NumberGenerator {

    private final Iterator<Integer> iterator;

    public MockNumberGenerator(List<Integer> expectedNumbers) {
        this.iterator = expectedNumbers.iterator();
    }

    @Override
    public int generate() {
        if (iterator.hasNext()) {
            return iterator.next();
        }

        throw new IllegalArgumentException();
    }
}