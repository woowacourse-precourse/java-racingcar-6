package domain;


import static constant.ConstantNumber.INITIAL_MOVE_COUNT;
import static constant.ConstantNumber.MOVE_DISTANCE;
import static constant.ConstantNumber.MOVING_FORWARD;

import validator.NameValidator;

public class Car {
    private final Name carName;
    public final MoveCount moveCount;

    public Car(String carName) {
        NameValidator.validateCarName(carName);
        this.carName = new Name(carName);
        this.moveCount = new MoveCount(INITIAL_MOVE_COUNT.getValue());
    }

    public String getCarName() {
        return carName.getName();
    }

    public void moveOrStop(int randomNumber) {
        if (randomNumber >= MOVING_FORWARD.getValue()) {
            int currentMoveCount = moveCount.getMoveCount();
            moveCount.setMoveCount(currentMoveCount + MOVE_DISTANCE.getValue());
        }
    }

    public int getCount() {
        return moveCount.getMoveCount();
    }
}
