package racingcar.model;

import static racingcar.Constants.MAX_CAR_NAME_SIZE;
import static racingcar.Constants.MAX_RANDOM_NUMBER;
import static racingcar.Constants.MIN_RANDOM_NUMBER;
import static racingcar.Constants.MOVE_CONDITION;
import static racingcar.exception.InputErrorCode.INVALID_CAR_NAME_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
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
        if (canMoving()) {
            moveCount++;
        }
    }

    private boolean canMoving() {
        final int random = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        return random >= MOVE_CONDITION;
    }

    private void validate() {
        if (name.length() > MAX_CAR_NAME_SIZE) {
            throw new InputException(INVALID_CAR_NAME_SIZE);
        }
    }

}
