package racingcar.domain;

import racingcar.global.Validation;

public class Car {

    private final String name;
    private int position;

    private Car(String name) {
        Validation.validateName(name);
        this.name = name;
        this.position = 0;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
