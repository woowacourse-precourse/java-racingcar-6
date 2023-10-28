package racingcar.model;

import racingcar.util.ValidateImpl;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        ValidateImpl.validateName(name);
        this.name = name;
        this.position = 0;
    }
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
