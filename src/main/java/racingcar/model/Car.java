package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void upDistance() { distance++; }
}
