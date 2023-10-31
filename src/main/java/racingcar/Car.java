package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void tryToMove() {
        if (canMove()) {
            moveFowrard();
        }
        else {
            stop();
        }
    }

    public boolean canMove() {
        int randomNum = Randoms.pickNumberInRange(0, 9);

        if (randomNum >= 4) {
            return true;
        } else {
            return false;
        }
    }

    public void moveFowrard() {
        distance++;
    }

    public void stop() {
        return;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }
}
