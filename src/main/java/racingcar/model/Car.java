package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final static int moveCondition = 4;
    private final String name;
    private int moveDistance;

    public Car(String name) {
        this.name = name;
        moveDistance = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public void move() {
        if (canMove()) {
            moveDistance += 1;
        }
    }

    private boolean canMove() {
        if (getMoveValue() >= moveCondition) {
            return true;
        }
        return false;
    }

    private int getMoveValue() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
