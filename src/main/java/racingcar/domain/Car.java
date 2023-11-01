package racingcar.domain;

import racingcar.common.RandomUtil;

public class Car {

    private final String name;
    private int moveForwardCount;

    private Car(String name) {
        this.name = name;
    }

    public static Car createFromName(String name) {
        return new Car(name);
    }

    public int getMoveForwardCount() {
        return moveForwardCount;
    }

    public void moveForward() {
        if (RandomUtil.isMoveForward()) {
            moveForwardCount++;
        }
    }

    public String getCurrentCondition() {
        return null;
    }

}
