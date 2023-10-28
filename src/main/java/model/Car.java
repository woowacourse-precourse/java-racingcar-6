package model;

import util.CarNameValidator;

public class Car {
    private final String name;
    private int position;

    public Car(final String name) {
        CarNameValidator.checkValidCarName(name);
        this.name = name;
        position = 0;
    }

    public void moveForward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
