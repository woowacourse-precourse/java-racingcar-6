package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN_MOVE_COND = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (getMoveCondition() >= MIN_MOVE_COND) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private int getMoveCondition() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
