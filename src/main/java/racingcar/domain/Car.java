package racingcar.domain;

import racingcar.exception.Validator;

public class Car {
    String name;
    int distance;

    public Car(String name) {
        Validator.empty(name);
        Validator.fiveOrLess(name);
        this.name = name;
        this.distance = 0;
    }
}
