package racingcar;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Car {
    public static final String ONE_STEP = "-";
    public static final int REFERENCE_NUMBER_VALUE = 4;

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (judge(number)) {
            distance++;
        }
    }

    private boolean judge(int number) {
        return number >= REFERENCE_NUMBER_VALUE;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
