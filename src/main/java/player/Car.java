package player;

import utils.Factory;

public class Car {
    private int distance = 0;

    public Car(){}

    public int getDistance() {
        return distance;
    }

    public void tryMove() {
        if (Factory.createRandomDigit() >= 4) {
            distance++;
        }
    }
}
