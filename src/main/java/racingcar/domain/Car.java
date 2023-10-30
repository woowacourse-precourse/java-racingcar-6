package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;

public class Car {

    private String name;
    private int distance;

    public Car(Car car) {
        this.name = car.name;
    }

    public Car(String name) {
        this.name = name;
    }

    public void increaseDistance() {
        distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
