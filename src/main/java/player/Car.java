package player;

import utils.Factory;

class Car {
    private int distance = 0;

    Car(){}

    int getDistance() {
        return distance;
    }

    void tryMove() {
        if (Factory.createRandomDigit() >= 4) {
            distance++;
        }
    }
}
