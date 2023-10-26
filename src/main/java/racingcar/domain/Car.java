package racingcar.domain;

public class Car {
    private CarName carName;
    private int movingDistance;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.movingDistance = 0;
    }
}
