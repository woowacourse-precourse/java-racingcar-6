package racingcar;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Car {
    public static final String ONE_STEP = "-";

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void move(boolean appropriateNumber) {
        if (appropriateNumber) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
