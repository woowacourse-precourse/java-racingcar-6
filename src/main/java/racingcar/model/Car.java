package racingcar.model;

import static racingcar.util.validator.InputValidator.isStringLengthValid;
import static racingcar.util.validator.InputValidator.checkBlank;

public class Car {
    private final String NAME;


    public Car(String name) {
        isStringLengthValid(name);
        checkBlank(name);
        this.NAME = name;
    }
}
