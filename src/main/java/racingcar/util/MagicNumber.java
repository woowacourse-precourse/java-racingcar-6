package racingcar.util;

public enum MagicNumber {

    MIN_NUMBER_SIZE(0),
    MAX_NUMBER_SIZE(9),
    MOVING_FORWARD(4),
    MAX_NAME_LENGTH(5),
    MIN_NAME_LENGTH(1);

    private final int number;

    MagicNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
