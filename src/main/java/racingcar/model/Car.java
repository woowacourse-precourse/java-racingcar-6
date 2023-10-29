package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MINIMUM_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int MOVING_CONDITION = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = MINIMUM_NUMBER;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
        if (isMovable(randomNumber)) {
            position++;
        }
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber >= MOVING_CONDITION;
    }

}
