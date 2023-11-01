package racingcar.domain;

import racingcar.utils.Util;

public class Car {
    private final String NAME;
    private int position = 0;

    public Car(String name) {
        this.NAME = name;
    }

    public String getName() {
        return NAME;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (Util.getRandomNumber() >= 4) {
            position++;
        }
    }

    public boolean winOrFail(int winDistance) {
        return position == winDistance;
    }
}
