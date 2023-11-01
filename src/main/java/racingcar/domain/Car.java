package racingcar.domain;

public class Car {

    private String carName;
    private int currentMovementCounts;

    public Car(String carName) {
        this.carName =carName;
        this.currentMovementCounts = 0;
    }

    public static Car createCar(String carName) {
        return new Car(carName);
    }

    public String getCarName() {
        return carName;
    }

    public int getCurrentMovementCounts() {
        return this.currentMovementCounts;
    }

    public void moveForward() {
        this.currentMovementCounts += 1;
    }
}
