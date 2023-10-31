package racingcar.domain;

import static racingcar.common.Constants.MAX_LENGTH_OF_NAME;
import static racingcar.common.Constants.MIN_NUMBER_FOR_MOVEMENT;
import static racingcar.common.Constants.MOVEMENT_DISTANCE;
import static racingcar.common.ExceptionMessages.INVALID_NAME_LENGTH_EXCEPTION;

public class Car {

    private final String name;
    private int meter;

    public Car(String name) {
        validateLength(name);
        this.name = name;
        this.meter = 0;
    }

    public String getName() {
        return name;
    }

    public int getMeter() {
        return meter;
    }

    public void move(int randomNumber) {
        if(randomNumber >= MIN_NUMBER_FOR_MOVEMENT) {
            meter += MOVEMENT_DISTANCE;
        }
    }

    private void validateLength(String name) {
        if(name.isEmpty() || name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_EXCEPTION);
        }
    }

}
