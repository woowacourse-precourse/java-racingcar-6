package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move() {
        if (canMove())
            distance++;
    }

    private boolean canMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
