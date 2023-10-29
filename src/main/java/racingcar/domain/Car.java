package racingcar.domain;

import racingcar.manager.RandomNumberGenerator;

public class Car {

    private final String name;

    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        if (RandomNumberGenerator.generateNumber() >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }
}
