package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    final private String name;
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

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    final public int getNumberOfMove() {
        return this.numberOfMove;
    }

    final public String getName() {
        return this.name;
    }

    public int compareTo(Car obj) {
        return this.numberOfMove - obj.numberOfMove;
    }
}
