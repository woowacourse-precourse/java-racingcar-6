package racingcar.model;

public class Car {
    private String carName;
    private int carCurrentPosition;

    public Car(String name) {
        this.carName = name;
        this.carCurrentPosition = 0;
    }

    public void moveFowardCar() {
        carCurrentPosition++;
    }

    public void setCarName(String name) {
        this.carName = name;
    }

    public int getCarCurrentPosition() {
        return carCurrentPosition;
    }
}
