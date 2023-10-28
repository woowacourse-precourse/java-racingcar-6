package racingcar.domain;

import racingcar.util.Utils;
import racingcar.validation.Validation;

public class Attemp {
    private final int number;
    public Attemp(String attempStr) {
        Validation.validateEmptyInput(attempStr);
        Validation.validateInteger(attempStr);
        number = Utils.stringToInt(attempStr);
        Validation.validateRange(number);
    }

    public int getNumber() {
        return number;
    }
}
