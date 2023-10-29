package racingcar.engine;

import racingcar.generator.NumberGenerator;

public class ReturnOneGenerator implements NumberGenerator {

    @Override
    public int generate(int startInclusive, int endInclusive) {
        return 1;
    }
}
