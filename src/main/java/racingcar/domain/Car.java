package racingcar.domain;

public class Car {

    private final String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public void move(int number) {
        if (number >= 4) {
            this.moveCount++;
        }
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public String getName() {
        return this.name;
    }
}
