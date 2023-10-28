package racingcar.domain;

import static racingcar.enums.Constant.MAX_NAME_LENGTH;

public class Car {

    private int moveCount;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        moveCount += 1;
    }

    public boolean isExceedMaxLength() {
        if (name.length() > MAX_NAME_LENGTH.getConstant()) {
            return true;
        }
        return false;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getName() {
        return name;
    }

}
