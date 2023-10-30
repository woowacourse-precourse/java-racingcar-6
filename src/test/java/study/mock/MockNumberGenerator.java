package study.mock;

import racingcar.domain.NumberGenerator;

import java.util.List;

public class MockNumberGenerator implements NumberGenerator {

    private List<Integer> randomNumbers;
    private int index;

    public void setRandomNumbers(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    @Override
    public int generate() {
        if (randomNumbers == null || randomNumbers.isEmpty()) {
            return 0;
        }
        return randomNumbers.get(index++);
    }
}
