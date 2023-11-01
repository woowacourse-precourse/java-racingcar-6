package racingcar.model;

import static racingcar.exception.RacingCarExceptionType.*;

public class RacingCar {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    public RacingCar(String name) {
        validateName(name);
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

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEEDED.getMessage());
        }
    }

}
