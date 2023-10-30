package racingcar.model;

import static racingcar.exception.RacingCarExceptionType.*;

public class RacingCar {
    private final String name;
    private int position = 0;

    public RacingCar(String name) {
        checkNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        position++;
    }

    private void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEEDED.getMessage());
        }
    }

}
