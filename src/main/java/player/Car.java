package player;

import utils.Factory;

class Car {
    private int distance = 0;
    private static final int threshold = 4;

    Car(){}

    int getDistance() {
        return distance;
    }

    void tryMove() {
        if (Factory.createRandomDigit() >= threshold) {
            distance++;
        }
    }
}
