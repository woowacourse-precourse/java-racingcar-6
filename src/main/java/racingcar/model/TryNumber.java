package racingcar.model;

import racingcar.validation.InputNumberValidation;

public class TryNumber {

    private final int tryNumber;

    public TryNumber(String number) {
        InputNumberValidation.validation(number);
        this.tryNumber = Integer.parseInt(number);
    }

    public boolean isNotOver(int tryCount) {
        return tryNumber != tryCount;
    }
}
