package racingcar.model;

import static racingcar.constants.ExceptionMessageConstants.*;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.length()>5) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
        this.name = name;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber>=4) {
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
