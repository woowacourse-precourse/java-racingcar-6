package racingcar.generator;

import racingcar.generator.NumberGenerator;

public class TestNumberGenerator implements NumberGenerator {

    @Override
    public int generateNumberRange(int min, int max) {
        int conditionNumber = 4;
        return conditionNumber + 1;
    }
}
