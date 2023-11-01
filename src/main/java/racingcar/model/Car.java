package racingcar.model;

import racingcar.Constants;
import racingcar.Utils;

public class Car {

    private final String NAME;
    private int position = 0;

    public Car(String name) {
        this.NAME = name;
    }

    public void moveForward() {
        if (Utils.getRandomNumber() >= Constants.BASELINE_NUM) {
            position++;
        }
    }
}
