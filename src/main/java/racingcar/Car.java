package racingcar;

public class Car {
    final String carName;
    int moveCount;

    public Car(String carName) {
        this.carName = carName;
    }

    String getCarName() {
        return carName;
    }

    int getMoveState() {
        return moveCount;
    }
}
