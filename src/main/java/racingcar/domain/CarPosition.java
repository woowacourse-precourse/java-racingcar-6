package racingcar.domain;

public class CarPosition {
    private static final int START_POSITION = 0;

    private int position;

    private CarPosition(int position) {
        this.position = position;
    }

    public static CarPosition createStartPosition() {
        return new CarPosition(START_POSITION);
    }

    public static CarPosition create(CarPosition carPosition) {
        return new CarPosition(carPosition.position);
    }

    public void driveForward() {
        ++position;
    }

    public int getPosition() {
        return position;
    }
}
