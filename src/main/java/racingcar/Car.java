package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Car implements Comparator<Car> {
    public static final String ONE_STEP = "-";

    private final String name;
    private final List<String> distance = new ArrayList<>();

    public Car(String name) {
        this.name = name;
    }

    public void move(boolean appropriateNumber) {
        if (appropriateNumber) {
            distance.add(ONE_STEP);
        }
    }

    @Override
    public int compare(Car o1, Car o2) {
        return o1.distance.size() - o2.distance.size();
    }

    public String getName() {
        return name;
    }

    public List<String> getDistance() {
        return Collections.unmodifiableList(distance);
    }
}
