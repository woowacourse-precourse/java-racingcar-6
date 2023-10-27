package racingcar.domain;

public class Car {

    private final String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public void move() {
        moveCount++;
    }

    public boolean isMaxMove(int maxMove) {
        return this.moveCount == maxMove;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
