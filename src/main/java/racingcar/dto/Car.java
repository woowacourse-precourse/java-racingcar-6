package racingcar.dto;

import racingcar.validator.InputValidator;

public class Car {
    private String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void increaseMoveCount() {
        this.moveCount++;
    }
}
