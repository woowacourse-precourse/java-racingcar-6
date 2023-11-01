package racingcar.domain;

import racingcar.manager.RandomNumberGenerator;

public class Car {

    private static final int MOVE_CRITERION = 4;
    private final String name;

    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        if (getGenerateNumber() >= MOVE_CRITERION) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }

    private int getGenerateNumber() {
        return RandomNumberGenerator.generateNumber();
    }
}
