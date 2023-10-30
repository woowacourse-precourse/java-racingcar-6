package racingcar.domain;

public class Car {
    private String name;
    private int tryCount;
    private int moveCount;

    public Car(String name, int tryCount) {
        this.name = name;
        this.tryCount = tryCount;
        this.moveCount = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
