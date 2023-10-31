package racingcar.model;

import racingcar.validator.TryNumberValidator;

public class TryNumber {

    private final int tryNumber;

    public TryNumber(String number) {
        TryNumberValidator.validate(number);
        this.tryNumber = Integer.parseInt(number);
    }


    public boolean isNotOver(int count) {
        if (tryNumber == count) {
            return false;
        }
        return true;
    }


}
