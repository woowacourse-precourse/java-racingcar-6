package racingcar.model;

import static racingcar.util.Constants.*;

import racingcar.model.dto.CarDTO;

public class Car {
    private final String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = ZERO;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public CarDTO toDTO() {
        return new CarDTO(this.name, this.moveCount);
    }

    public boolean isSameMoveCount(int moveCount) {
        return this.moveCount == moveCount;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVING_CONDITION) {
            moveCount++;
        }
    }
}
