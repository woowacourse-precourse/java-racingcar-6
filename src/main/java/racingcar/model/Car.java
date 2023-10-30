package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

    String name;
    int moveCount;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.moveCount = 0;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw (new IllegalArgumentException());
        }
    }

    public void move() {
        if (canMove()) {
            moveCount++;
        }
    }

    private boolean canMove() {
        return (Randoms.pickNumberInRange(0, 9) <= 4);
    }

    public String path() {
        return (name + " : " + "-".repeat(moveCount));
    }
}
