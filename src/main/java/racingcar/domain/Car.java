package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int moveCount;

    public Car(String name, int moveCount) {
        validateNameLength(name);
        this.name = name;
        this.moveCount = moveCount;
    }

    public Car(String name) {
        this(name, 0);
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void moveWithRandomNumber() {
        int num = Randoms.pickNumberInRange(0, 9);
        if (num >= 4) {
            this.moveCount++;
        }
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", moveCount=" + moveCount +
                '}';
    }
}
