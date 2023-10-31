package racingcar.car;

import static racingcar.constant.Constants.MOVING_DISTANCE;

public class Car {
    private String name;
    private int location;

    Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void move() {
        location += MOVING_DISTANCE;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
