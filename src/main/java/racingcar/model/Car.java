package racingcar.model;

import static racingcar.util.GameNumber.MOVING_CONDITION;

public class Car {

    private final String name;
    private int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move(int moving) {
        if (movable(moving)) {
            distance++;
        }
    }

    private boolean movable(int moving) {
        return moving >= MOVING_CONDITION;
    }
}
