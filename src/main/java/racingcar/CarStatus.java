package racingcar;

public enum CarStatus {
    MOVE(1),
    STOP(0);

    private int carStatus;
    CarStatus(int carStatus) {
        this.carStatus = carStatus;
    }
}
