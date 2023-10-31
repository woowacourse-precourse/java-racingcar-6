package racingcar;

public enum Movement {
    FORWARD(1), STOP(0);

    private final int addingValue;

    Movement(int addingValue) {
        this.addingValue = addingValue;
    }

    public int addingValue() {
        return addingValue;
    }

    public static Movement from(int randomNumber) {
        if (randomNumber >= 4) {
            return FORWARD;
        }
        return STOP;
    }
}