package racingcar.model;

import racingcar.util.validate.CarValidateImpl;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        CarValidateImpl.createVaule(name);
        this.name = name;
        this.position = 0;
    }
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
