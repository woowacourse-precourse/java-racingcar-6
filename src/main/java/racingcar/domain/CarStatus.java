package racingcar.domain;

public class CarStatus {
    private final String name;
    private final int driveCount;

    public CarStatus(String name, int driveCount) {
        this.name = name;
        this.driveCount = driveCount;
    }

    public String getName() {
        return name;
    }

    public int getDriveCount() {
        return driveCount;
    }
}
