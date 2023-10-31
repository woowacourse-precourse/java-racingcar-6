package racingcar.enumType.number;

public enum NumberConstant {

    CAR_NAME_MIN_LENGTH(1)
    , CAR_NAME_MAX_LENGTH(5)
    , RACE_MIN_ROUND(1)
    , RANDOM_MIN_NUMBER(4)
    , RANDOM_MIN_RANGE(0)
    , RANDOM_MAX_RANGE(9)
    , FORMAT_NUMBER(2);

    private final int number;

    NumberConstant(final int number) {
        this.number = number;
    }

    public int getValue() {
        return number;
    }
}
