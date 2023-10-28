package domain;

import static constant.ConstantString.MOVING_FORWARD;

import validator.NameValidator;

public class Car {
    private final Name carName;
    public final MoveCount moveCount;

    public Car(String carName) {
        NameValidator.validateCarName(carName);
        this.carName = new Name(carName);
        this.moveCount = new MoveCount();
    }

    public String getCarName() {
        return carName.getName();
    }

    public void moveOrStop(int randomNumber) {
        if (randomNumber >= MOVING_FORWARD) {
            moveCount.plusCount();
        }
    }

    public int getCount() {
        return moveCount.getCount();
    }
}
