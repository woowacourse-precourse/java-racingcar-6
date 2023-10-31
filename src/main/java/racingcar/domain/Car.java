package racingcar.domain;

import racingcar.validator.CarNameInputValidator;
import racingcar.validator.InputValidator;

public class Car {
    private static final int MOVABLE_BOUND = 4;

    private final String name;
    private int position = 0;
    private final InputValidator validator = new CarNameInputValidator();

    public Car(String name) {
        validator.validateInput(name);
        this.name = name;
    }

    public Car(String name, int position) {
        validator.validateInput(name);
        this.name = name;
        this.position = position;
    }

    public boolean canMove(int pickNumberInRange) {
        if (MOVABLE_BOUND <= pickNumberInRange) {
            return true;
        }
        return false;
    }

    public void move(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    public void printCarStatus() {
        System.out.println(name + " : " + "-".repeat(position));
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
