package racingcar;

import java.util.List;

public class Car {
    public static final String ONE_STEP = "-";

    private final String name;
    private List<String> distance;

    public Car(String name) {
        this.name = name;
    }

    public void move(boolean biggerThanFour) {
        distance.add(ONE_STEP);
    }

    public void findLongestDistance() {

    }

    public void findWinners() {

    }
}
