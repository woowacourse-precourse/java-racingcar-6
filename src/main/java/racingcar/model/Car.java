package racingcar.model;

import racingcar.utils.RandomNumberGenerator;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        if(RandomNumberGenerator.generateRandomNumber() >= 4) {
            this.position++;
        }
    }
}
