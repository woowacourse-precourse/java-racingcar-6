package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {
    public static final String ONE_STEP = "-";

    private final String name;
    private List<String> distance = new ArrayList<>();

    public Car(String name) {
        this.name = name;
    }

    public void move(boolean biggerThanFour) {
        if (biggerThanFour) {
            distance.add(ONE_STEP);
        }
    }

    public void findLongestDistance() {

    }

    public void findWinners() {

    }

    public String getName() {
        return name;
    }

    public List<String> getDistance() {
        return Collections.unmodifiableList(distance);
    }
}
