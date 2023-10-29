package racingcar.model;

import static racingcar.exception.InputErrorCode.INVALID_CAR_NAME_SIZE;

import racingcar.exception.InputException;

public class Car {

    private final String name;

    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
        validate();
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move() {
        moveCount++;
    }

    private void validate() {
        if (name.length() > 5) {
            throw new InputException(INVALID_CAR_NAME_SIZE);
        }
    }

}
