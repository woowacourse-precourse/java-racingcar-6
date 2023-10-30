package racingcar.model;

public class Car {
    private String carName;
    private int moveCount;
    public Car(String carName) {
        this.carName = carName;
    }
    public String getCarName() {
        return carName;
    }
    public int getMoveCount() {
        return moveCount;
    }
    public void move() {
        moveCount++;
    }
}
