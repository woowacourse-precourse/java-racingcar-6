package racingcar;

public class Car {
    final String carName;
    int moveState;

    public Car(String carName) {
        this.carName = carName;
    }

    String getCarName() {
        return carName;
    }

    int getMoveState(){
        return moveState;
    }
}
