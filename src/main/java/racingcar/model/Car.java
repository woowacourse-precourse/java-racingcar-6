package racingcar.model;

public class Car {
    private String carName;
    private int carCurrentLocation;

    public Car(String name) {
        this.carName = name;
        this.carCurrentLocation = 0;
    }

    public void moveFowardCar() {
        carCurrentLocation++;
    }

    public void setCarName(String name) {
        this.carName = name;
    }
}
