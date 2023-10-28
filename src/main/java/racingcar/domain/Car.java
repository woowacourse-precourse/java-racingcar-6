package racingcar.domain;

import racingcar.RandomNumberGenerator;

public class Car {

    private String name;
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

    public int getPosition() {
        return this.position;
    }
}
