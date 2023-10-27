package racingcar.model;

import racingcar.validator.Validator;

public class Car {
    private final String name;
    private final int position;

    private Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public static Car createCar(String name) {
        validate(name);
        return new Car(name);
    }

    private static void validate(String name) {
        Validator.checkEmptyCarName(name);
        Validator.checkCarNameRange(name);
    }
}