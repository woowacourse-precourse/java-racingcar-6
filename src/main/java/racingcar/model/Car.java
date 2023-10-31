package racingcar.model;

import racingcar.util.Constant;
import racingcar.util.Util;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        if (Util.getRandomNumber() >= Constant.MOVE_MINIMUM_NUM)
            position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
