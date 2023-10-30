package racingcar;

public class Car {

    private CarName carName;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName.getCarName();
    }
}
