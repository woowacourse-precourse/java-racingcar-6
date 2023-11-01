package racingcar.model;

import racingcar.Constants;
import racingcar.Util;

public class Car {

    private final String NAME;
    private int position;

    private Car(String name) {
        this.NAME = name;
        this.position = 0;
    }

    public static Car nameOf(String name) {
        return new Car(name);
    }

    public String getName() {
        return NAME;
    }

    public int getPosition() {
        return position;
    }
    public void move() {

        if (Util.pickNumberInRange() >= Constants.START_NUM) {
            position++;
        }
    }
}
