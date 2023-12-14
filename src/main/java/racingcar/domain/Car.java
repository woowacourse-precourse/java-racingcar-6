package racingcar.domain;

import racingcar.global.util.RandomNumberGenerator;

public class Car {
    private static final int THRESHOLD = 4;
    private static final int START = 0;
    private static final int END = 9;
    public static final int INTERVAL = 1;
    private Name name;
    private int moved;

    public Car(Name name) {
        this.name = name;
        this.moved = 0;
    }

    public void move() {
        if (canMove()) {
            moved += INTERVAL;
        }
    }

    private boolean canMove() {
        int number = RandomNumberGenerator.generate(START, END);
        if (number >= THRESHOLD) {
            return true;
        }
        return false;
    }

    public int moved() {
        return moved;
    }

    public String name() {
        return name.getValue();
    }
}
