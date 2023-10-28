package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) moveForward();
    }

    private void moveForward() {
        this.distance ++;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getStatus() {
        return this.name + " : "
                + "-".repeat(Math.max(0, this.distance));
    }

    public int getDistance() {
        return distance;
    }
}
