package racingcar.model;

import static racingcar.constants.ExceptionMessageConstants.*;

public class Car {
    private static final int MAX_LENGTH = 5;
    private static final int MIN_NUMBER = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
        this.name = name;
    }

    public void moveForward(int randomNumber) {
        if (canMove(randomNumber)) {
            move();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getCarStatus() {
        return name + " : " + "-".repeat(position);
    }

    private boolean canMove(int randomNumber) {
        return randomNumber >= MIN_NUMBER;
    }

    private void move() {
        position++;
    }
}
