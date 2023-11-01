package racingcar.model;

public class Car {
    private String carName;
    private int carCurrentPosition;

    public Car(String name) {
        this.carName = "";
        this.carCurrentPosition = 0;
    }

    public void moveFowardCar() {
        carCurrentPosition++;
    }

    public void setCarName(String name) {
        this.carName = name;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarCurrentPosition() {
        return carCurrentPosition;
    }
}
