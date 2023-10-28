package racingcar.domain;

public class Car {

    private final String name;
    private int moveCount;

    public Car(String carNames) {
        this.name = carNames;
        this.moveCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move() {
        this.moveCount++;
    }


}
