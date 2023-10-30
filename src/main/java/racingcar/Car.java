package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int numberOfMove;

    public Car(String name) {
        this.name = name;
        numberOfMove = 0;
    }

    public void moveFoward() {
        if (getRandomNumber() >= 4)
            numberOfMove++;
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public int getNumberOfMove() {
        return this.numberOfMove;
    }

    public String getName() {
        return this.name;
    }
}
