package domain;

import static constant.ConstantString.MOVING_FORWARD;
import static constant.ConstantString.INITIAL_MOVE_COUNT;

import validator.NameValidator;

public class Car {
    private final Name carName;
    public final MoveCount moveCount;

    public Car(String carName) {
        NameValidator.validateCarName(carName);
        this.carName = new Name(carName);
        this.moveCount = new MoveCount(INITIAL_MOVE_COUNT);
    }

    public String getCarName() {
        return carName.getName();
    }

    public void moveOrStop(int randomNumber) {
        if (randomNumber >= MOVING_FORWARD) {
            int currentMoveCount = moveCount.getMoveCount();
            moveCount.setMoveCount(currentMoveCount + 1);
        }
    }

    public int getCount() {
        return moveCount.getMoveCount();
    }
}
