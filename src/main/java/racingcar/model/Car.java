package racingcar.model;

import racingcar.utils.RandomNumberGenerator;

public class Car {

    private static final int GO = 4;

    private int distance = 0;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void go() {
        int randomNumber = RandomNumberGenerator.generateRandomNumber();
        if (randomNumber >= GO) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

}
