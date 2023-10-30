package racingcar.models;

import static racingcar.utils.Constants.MIN_MOVED_DISTANCE;

public class Car {
    private String carName;
    private int carMileage = MIN_MOVED_DISTANCE;

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
