package racingcar.model;

public class Car {

    private String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public String getName() { return this.name; }
    public int getMoveCount() { return this.moveCount; }

    public void moveForward() {
        this.moveCount++;
    }
}
