package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.InputValidator;

public class Car {
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;
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
        moveDistance++;
    }

    public int generateMoveValue() {
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }
}
