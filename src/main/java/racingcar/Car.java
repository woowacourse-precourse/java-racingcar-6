package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int numberOfMove;

    public Car(String name) {
        this.name = name;
        this.numberOfMove = 0;
    }

    public Car(String name, int move) {
        this.name = name;
        this.numberOfMove = move;
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
