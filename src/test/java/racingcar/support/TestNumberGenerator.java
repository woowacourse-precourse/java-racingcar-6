package racingcar.support;

import racingcar.generator.NumberGenerator;

public class TestNumberGenerator implements NumberGenerator {
    private int number;

    @Override
    public int generateNumber() {
        return number;
    }

    public void setReturnNumber(int number) {
        this.number = number;
    }
}
