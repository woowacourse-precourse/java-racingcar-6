package racingcar.model;

import static racingcar.utils.Constants.INIT_START_POSITION;

public class Car {
    private final String name;
    private int distance;

    private Car(String name) {
        this.name = name;
        this.distance = INIT_START_POSITION;
    }

    public static Car makeCarByName(String carName) {
        return new Car(carName);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void go() {
        distance++;
    }
}
