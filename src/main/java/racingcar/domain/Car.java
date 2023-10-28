package racingcar.domain;

import racingcar.utils.validation.InputValidation;

public class Car {
    private String name;
    private int moveCount = 0;

    public Car(String name) {
        InputValidation.validateNameLength(name);
        this.name = name;
    }
}
