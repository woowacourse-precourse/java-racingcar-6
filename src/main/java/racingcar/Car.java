package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int position = 0;
    private static final int MIN_MOVABLE_RANGE = 1;
    private static final int MAX_MOVABLE_RANGE = 9;
    private static final int MIN_MOVABLE = 4;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move() {
        if (isMovable()) {
            position += 1;
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(MIN_MOVABLE_RANGE, MAX_MOVABLE_RANGE) >= MIN_MOVABLE;
    }
}
