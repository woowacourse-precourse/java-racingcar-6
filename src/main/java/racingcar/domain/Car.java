package racingcar.domain;

import racingcar.utils.GenerateRandomNumber;

public class Car {

    private static final int MOVABLE_MIN_NUMBER = 4;
    private final String name;
    private int movement;

    public Car(String name) {
        this.name = name;
        this.movement = 0;
    }

    public void goForward(int random) {
        if (random >= MOVABLE_MIN_NUMBER)
            movement++;
    }

    public String getName() {
        return name;
    }

    public int getMovement() {
        return movement;
    }
}
