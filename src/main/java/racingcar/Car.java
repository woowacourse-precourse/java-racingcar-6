package racingcar;

public class Car {

    CarName carName;
    int moveCount;

    public Car(CarName carName) {
        this.carName = carName;
        moveCount = 0;
    }

    public boolean move(int random) {
        if (random >= 4) {
            moveCount++;
            return true;
        }
        return false;
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getMoveCount() {
        return moveCount;
    }
}
