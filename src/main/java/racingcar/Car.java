package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int moveDistance = 0;

    Car(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    int getMoveDistance() {
        return this.moveDistance;
    }

    boolean isMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    void move() {
        if (isMove())
            moveDistance++;
    }
}
