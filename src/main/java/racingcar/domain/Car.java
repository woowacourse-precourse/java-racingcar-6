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

    public String getName() {
        return licensePlate.getName();
    }

    public int getDriveCount() {
        return driveCount;
    }
}
