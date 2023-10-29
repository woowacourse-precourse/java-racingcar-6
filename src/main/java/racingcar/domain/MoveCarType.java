package racingcar.domain;

public enum MoveCarType {
    STOP(0),
    FORWARD(1);

    private final int movingPosition;

    MoveCarType(int movingPosition) {
        this.movingPosition = movingPosition;
    }

    public int getMovingPosition() {
        return movingPosition;
    }
}
