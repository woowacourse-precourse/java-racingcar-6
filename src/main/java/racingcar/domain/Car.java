package racingcar.domain;

import racingcar.common.Constants;

public class Car {

    private final String name;
    private int moveForwardCount;

    private Car(String name) {
        this.name = name;
    }

    public static Car createFromName(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getMoveForwardCount() {
        return moveForwardCount;
    }

    public void moveForward(int randomNumber) {
        if (isMoveForward(randomNumber)) {
            moveForwardCount++;
        }
    }

    private boolean isMoveForward(int randomNumber) {
        return randomNumber >= Constants.MOVE_FORWARD;
    }

    public String getCurrentCondition() {
        String count = Constants.HYPHEN.repeat(moveForwardCount);
        return String.format("%s : %s", name, count);
    }

}
