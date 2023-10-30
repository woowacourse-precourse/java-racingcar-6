package racingcar.domain;

public class Car {
    private String name;
    private Integer moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public void go() {
        moveCount++;
    }

    public String getName() {
        return name;
    }

    public Integer getMoveCount() {
        return moveCount;
    }
}
