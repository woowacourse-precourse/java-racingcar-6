package racingcar.domain;

import racingcar.util.Constant;

public class Car {
    private final String name;
    private int moving;

    public Car(String name) {
        this.name = name;
        this.moving = 0;
    }

    public void move(int value) {
        if (value > Constant.MIN_CAN_MOVE_VALUE) {
            this.moving += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getMoving() {
        return moving;
    }
}
