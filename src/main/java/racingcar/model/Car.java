package racingcar.model;

import java.util.Objects;
import racingcar.utils.Validation;

public class Car implements Comparable<Car> {
    private final String name;
    private int dist;

    public Car(String name) {
        Validation.validateName(name);
        this.name = name;
        this.dist = 0;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name, "-".repeat(dist));
    }

    private Integer getDist() {
        return dist;
    }

    public void goForward() {
        dist++;
    }

    @Override
    public int compareTo(Car other) {
        Objects.requireNonNull(other);
        return Integer.compare(getDist(), other.getDist());
    }
}
