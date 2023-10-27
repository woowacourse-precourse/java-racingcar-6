package racingcar.domain.resource;

public enum CarGameValue {
    POWER(1)
    , CAR_MOVE_MIN_NUMBER(0)
    , CAR_MOVE_MAX_NUMBER(9)
    , CAR_MOVE_MORE_THAN_NUMBER(4)
    , CAR_NAME_MAX_LENGTH(5);

    private final int number;

    CarGameValue(int number) {
        this.number = number;
    }

    public int getValue() {
        return this.number;
    }
}
