package racingcar.domain;

public class Car {
    private final String name;
    private Integer moveCount = 0;

    Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move() {
        moveCount++;
    }

    public Integer getMoveCount() {
        return moveCount;
    }
}
