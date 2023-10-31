package racingcar.domain;

import racingcar.util.RandomGenerator;

public class Car {
    private static final int MOVING_POINT = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (RandomGenerator.generate() >= MOVING_POINT) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
