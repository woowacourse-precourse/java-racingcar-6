package racingcar.model;

import racingcar.constants.ErrorMessage;
import racingcar.exception.CarNameLengthException;

public class Car {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new CarNameLengthException(ErrorMessage.CAR_NAME_LENGTH_ERROR.getMessage());
        }
    }

    public void movePosition() {
        this.position++;
    }
}
