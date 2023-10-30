package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;

    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public Car(String name, int distance) {
        this(name);
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        if (RandomManager.isMovingCar()) {
            distance++;
        }
    }

    public String getStatus() {
        return this.name + " : " + "-".repeat(distance);
    }

    public static List<Car> parseCars(String input) {
        // TODO : 미구현
        return new ArrayList<Car>();
    }
}
