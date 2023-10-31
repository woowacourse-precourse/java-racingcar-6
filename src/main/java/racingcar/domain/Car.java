package racingcar.domain;

public class Car {
    String name = null;
    int moveCount = 0;

    public Car(String carName) {
        name = carName;
    }

    public void addCarCount() {
        moveCount++;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
