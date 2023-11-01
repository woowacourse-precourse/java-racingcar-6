package racingcar.domain;

import static racingcar.common.Constants.MIN_NUMBER_FOR_MOVEMENT;
import static racingcar.common.Constants.MOVEMENT_DISTANCE;

public class Car {

    private final String name;
    private int meter;

    public Car(String name) {
        this.name = name;
        this.meter = 0;
    }

    public String getName() {
        return name;
    }

    public int getMeter() {
        return meter;
    }

    public void move(int randomNumber) {
        if(randomNumber >= MIN_NUMBER_FOR_MOVEMENT) {
            meter += MOVEMENT_DISTANCE;
        }
    }

}
