package racingcar.mock;

import racingcar.domain.numberpicker.RandomNumberPicker;

public class FakeRandomNumberPicker implements RandomNumberPicker {

    private final int randomDigit;

    public FakeRandomNumberPicker(int randomDigit) {
        this.randomDigit = randomDigit;
    }

    @Override
    public int pickOneDigit() {
        return this.randomDigit;
    }

}
