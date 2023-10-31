package racingcar.mock;

import racingcar.model.NumberGenerator;

public class TestNumberGenerator implements NumberGenerator {

    private final int number;

    public TestNumberGenerator(int number){
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}