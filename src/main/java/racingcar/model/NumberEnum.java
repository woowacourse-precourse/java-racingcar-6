package racingcar.model;

public enum NumberEnum {
    MIN_RANGE(0),
    MAX_RANGE(9),
    REQUIREMENT_MOVE(4),
    MIN_SIZE(2),
    MAX_LENGTH(5),
    ZERO(0),
    MIN_TRY_NUMBER(1);

    private int Number;

    NumberEnum(int number) {
        Number = number;
    }

    public int getNumber() {
        return Number;
    }
}
