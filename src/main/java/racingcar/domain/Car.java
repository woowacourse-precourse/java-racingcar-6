package racingcar.domain;

import static racingcar.constant.Console.PROGRESS;
import static racingcar.constant.Console.SEPARATOR;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move() {
        this.distance += 1;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + SEPARATOR.message() + PROGRESS.message().repeat(distance);
    }
}
