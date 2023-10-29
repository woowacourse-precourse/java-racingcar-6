package racingcar.domain;

public class Car {

    private final String name;
    private int moveCount;

    public Car(String carNames, int moveCount) {
        this.name = carNames;
        this.moveCount = moveCount;
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
