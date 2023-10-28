package racingcar.model;

import static racingcar.constants.ExceptionMessageConstants.*;

public class Car {
    public static final int MAX_LENGTH = 5;
    public static final int MIN_NUMBER = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
        this.name = name;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= MIN_NUMBER) {
            position++;
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
}
