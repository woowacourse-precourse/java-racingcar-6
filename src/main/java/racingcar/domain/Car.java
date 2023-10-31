package racingcar.domain;

public class Car {
    private String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
