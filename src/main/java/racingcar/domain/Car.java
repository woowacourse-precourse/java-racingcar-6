package racingcar.domain;

import static racingcar.Constant.*;

public class Car {
    private final String name;
    private int point;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        point++;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return name +
                IS +
                LINE.repeat(point);
    }

}
