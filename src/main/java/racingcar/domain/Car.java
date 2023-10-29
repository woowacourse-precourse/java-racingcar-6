package racingcar.domain;

public class Car {
    private final LicensePlate licensePlate;
    private int driveCount;

    public Car(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
        this.driveCount = 0;
    }

    public void drive() {
        driveCount++;
    }

    public CarStatus getStatus() {
        return new CarStatus(licensePlate.getName(), driveCount);
    }
}
