package racingcar.domain;

public class Car {
    private final String name;
    private int driveCount;

    public Car(String name) {
        this.name = name;
        this.driveCount = 0;
    }

    public void drive() {
        driveCount++;
    }

    public CarStatus getStatus() {
        return new CarStatus(name, driveCount);
    }
}
