package racingcar.domain;

public class Car {
    private String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void addMoveCount() {
        moveCount++;
    }
}
