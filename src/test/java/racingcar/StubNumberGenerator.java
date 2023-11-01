package racingcar;

import racingcar.model.NumberGenerator;

public class StubNumberGenerator implements NumberGenerator {

    private int[] values;
    private int index = 0;

    public StubNumberGenerator(int... values) {
        this.values = values;
    }

    @Override
    public int generate() {
        return values[index++];
    }
}