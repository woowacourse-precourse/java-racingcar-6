package model;

public class Car {
    private final String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public String toString() {
        return carName;
    }
}
