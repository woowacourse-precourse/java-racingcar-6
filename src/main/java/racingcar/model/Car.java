package racingcar.model;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void canIMove() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        if (randomNumberGenerator.pickRandomNumber() >= 4) {
            move();
        }
    }

    public void move() {
        distance += 1;
    }

    public int findMaxDistance(int max) {
        if (distance > max) {
            max = distance;
        }
        return max;
    }

    public boolean isSameDistance(int max) {
        if (distance == max) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
