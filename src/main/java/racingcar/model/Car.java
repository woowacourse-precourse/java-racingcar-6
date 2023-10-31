package racingcar.model;

import static racingcar.utils.Error.*;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validateCarNameLength(name);
        this.name = name;
        this.position = 0;
    }

    private static void validateCarNameLength(String name) {
        if (name.isBlank() || name.length() > 5)
            throwError(INVALID_NAME_LENGTH);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position++;
    }
}
