package racingcar.domain;

import racingcar.common.Constants;
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
        String count = Constants.HYPHEN.repeat(moveForwardCount);
        return String.format("%s : %s", name, count);
    }

}
