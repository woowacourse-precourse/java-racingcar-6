package racingcar.model;

public class Car {
    private final String name;
    private int moveCount;

    public Car(final String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public void move() {
        moveCount++;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    @Override
    public boolean equals(Object obj) {
        Car other = (Car) obj;
        return this.name.equals(other.name) && this.moveCount == other.moveCount;
    }
}
