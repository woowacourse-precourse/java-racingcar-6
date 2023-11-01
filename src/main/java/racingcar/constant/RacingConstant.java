package racingcar.constant;

public enum RacingConstant {
    MAX_CAR_NAME_LENGTH(5),
    FORWARD_NUMBER(4);

    private final int value;

    RacingConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

