package racingcar.domain;

import racingcar.constraint.Constraint;
import racingcar.utils.Utils;

public class Attempt {
    private final int number;

    public Attempt(String attemptStr) {
        Constraint.constraintEmptyInput(attemptStr);
        Constraint.constraintInt(attemptStr);
        number = Utils.stringToInt(attemptStr);
        Constraint.constraintRange(number);
    }

    public int getNumber() {
        return number;
    }
}
