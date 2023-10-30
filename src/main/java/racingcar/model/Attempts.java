package racingcar.model;

import racingcar.utils.Validator;

public class Attempts {
    private final int number;

    public Attempts(int number) {
        this.number = number;
    }

    public Attempts(String value) {
        Validator.validateNumberOfAttemptsInput(value);
        this.number = Integer.valueOf(value);
    }

    public int getNumber() {
        return number;
    }
}
