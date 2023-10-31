package racingcar.domain;

import racingcar.util.Utils;
import racingcar.validation.Validation;

public class Attempt {
    private final int number;

    public Attempt(String attemptStr) {
        Validation.validateEmptyInput(attemptStr);
        Validation.validateInteger(attemptStr);
        number = Utils.stringToInt(attemptStr);
        Validation.validateRange(number);
    }

    public int getNumber() {
        return number;
    }
}
