package racingcar.dto;

import racingcar.validator.InputValidator;

public class Car {
    private String name;
    private int moveCount;
    private InputValidator validator = InputValidator.getInstance();

    public Car(String name) {
        validator.validateNameLengthRange(name);
        this.name = name;
        this.moveCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void increaseMoveCount(int moveCount) {
        this.moveCount += moveCount;
    }
}
