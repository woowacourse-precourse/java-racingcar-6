package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.InputValidator;

public class Car {
    private final String name;
    private int moveDistance;

    public Car(String name) {
        InputValidator.validateCarName(name);
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
        moveDistance += 1;
    }

    public int generateMoveValue() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
