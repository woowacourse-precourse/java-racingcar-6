package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_CONDITION_NUMBER = 4;

    private final String name;
    private int moveCount = 0;

    public static Car createCar(String name) {
        return new Car(name);
    }

    private Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move() {
        int moveNumber = Randoms.pickNumberInRange(0,9);
        if (moveNumber >= MOVE_CONDITION_NUMBER) {
            moveCount++;
        }
    }

    public int getMoveCount() {
        return moveCount;
    }
}
