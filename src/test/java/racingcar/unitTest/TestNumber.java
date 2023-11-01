package racingcar.unitTest;

import racingcar.model.RacingNumber;

public class TestNumber implements RacingNumber {

    private Integer testNumber;

    public TestNumber(Integer testNumber) {
        this.testNumber = testNumber;
    }

    @Override
    public Integer generate() {
        return testNumber;
    }
}
