package racingcar;

public enum Movement {
    FORWARD(1), STOP(0);

    private static final int MOVEMENT_STANDARD = 4;
    private final int addingValue;

    Movement(int addingValue) {
        this.addingValue = addingValue;
    }

    public int addingValue() {
        return addingValue;
    }

    public static Movement from(int randomNumber) {
        if (randomNumber >= MOVEMENT_STANDARD) {
            return FORWARD;
        }
        return STOP;
    }
}