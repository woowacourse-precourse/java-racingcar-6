package racingcar.models;

public class Car {
    private String carName;
    private int carMileage = 0;

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarMileage() {
        return carMileage;
    }

    public void moveForward() {
        carMileage++;
    }
}
