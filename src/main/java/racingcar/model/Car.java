package racingcar.model;

import static racingcar.util.validator.InputValidator.IsStringLengthValid;
import static racingcar.util.validator.InputValidator.checkBlank;

public class Car {
    private final String NAME;


    public Car(String name) {
        IsStringLengthValid(name);
        checkBlank(name);
        this.NAME = name;
    }
}
