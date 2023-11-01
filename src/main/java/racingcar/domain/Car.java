package racingcar.domain;

public class Car {
    private final String carName;
    private int moveForwardCount;

    public Car(String carName) {
        this.carName = carName;
    }

    public void setMoveForwardCount(int countOne) {
        this.moveForwardCount += countOne;
    }

    public String getCarName() {
        return carName;
    }

    public int getMoveForwardCount() {
        return moveForwardCount;
    }
}
