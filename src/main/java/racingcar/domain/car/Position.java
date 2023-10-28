package racingcar.domain.car;

public class Position {
    private static final int MOVEMENT_DISTANCE = 1;
    private static final int MINIMUM_MOVEMENT_NUMBER = 4;
    private static final int MAXIMUM_MOVEMENT_NUMBER = 9;
    private int position;

    public Position() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void forward(int number) {
        if (isValidNumberToIncreasePosition(number)) {
            position += MOVEMENT_DISTANCE;
        }
    }

    private boolean isValidNumberToIncreasePosition(int number) {
        return MINIMUM_MOVEMENT_NUMBER <= number && number <= MAXIMUM_MOVEMENT_NUMBER;
    }
}
