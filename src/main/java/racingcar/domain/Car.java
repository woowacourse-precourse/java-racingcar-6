package racingcar.domain;

import racingcar.util.RandomNumber;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int POSITION_INITIAL_VALUE = 0;
    private static final int POSITION_INCREMENT = 1;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = POSITION_INITIAL_VALUE;
    }

    public String getName() {
        return name;
    }

    public void move() {
        if (RandomNumber.generateRandomNumber() >= MOVE_THRESHOLD) {
            position += POSITION_INCREMENT;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getPositionString() {
        return "-".repeat(position);
    }
}

