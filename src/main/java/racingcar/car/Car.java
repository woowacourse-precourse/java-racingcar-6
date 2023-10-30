package racingcar.car;

import static racingcar.constant.Constants.DISTANCE;

public class Car {
    private String name;
    private int location;

    Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void move() {
        location += DISTANCE;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
