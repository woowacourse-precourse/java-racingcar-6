package racingcar.model;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private static final int MOVE_BOUNDARY = 4;
    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        if (isMovable()) {
            this.position++;
        }
    }

    private boolean isMovable() {
        return RandomNumberGenerator.generateRandomNumber() >= MOVE_BOUNDARY;
    }
}
