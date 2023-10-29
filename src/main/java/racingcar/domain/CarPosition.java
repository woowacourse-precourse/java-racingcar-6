package racingcar.domain;

public class CarPosition {
    private static final int START_POSITION = 0;

    private int position;

    public CarPosition() {
        position = START_POSITION;
    }

    public void driveForward() {
        ++position;
    }

    public int getPosition() {
        return position;
    }
}
