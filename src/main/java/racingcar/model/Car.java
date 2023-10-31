package racingcar.model;

import racingcar.util.RandomIntGenerator;

public class Car {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int ONE_STEP = 1;
    private static final int MINIMUM_MOVE_CONDITION = 4;
    private final String name;
    private int moveCount;

    public Car(String name) {
        checkNameLength(name);
        this.name = name;
        this.moveCount = 0;
    }

    public void tryMove() {
        if (canMove()) {
            this.moveCount += ONE_STEP;
        }
    }

    private boolean canMove() {
        int pickedNumber = RandomIntGenerator.pickNumber();
        return pickedNumber >= MINIMUM_MOVE_CONDITION;
    }

    private void checkNameLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public int getMoveCount() {
        return moveCount;
    }
}
