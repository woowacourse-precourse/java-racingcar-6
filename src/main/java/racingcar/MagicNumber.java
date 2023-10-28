package racingcar;

public enum MagicNumber {
    RANDOM_MIN(0),
    RANDOM_MAX(9),
    CAM_MOVE_MIN(4),
    CAR_NAME_LENGTH_MAX(5);

    private int magicNumber;

    MagicNumber(int magicNumber) {
        this.magicNumber = magicNumber;
    }

    public int getValue() {
        return magicNumber;
    }
}
