package racingcar.model;

import static racingcar.validator.InputValidator.validateLenOfCarName;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        validateLenOfCarName(name);
        this.name = name;
        this.distance = 0;
    }

    public void move() {
        this.distance += 1;
    }
}
